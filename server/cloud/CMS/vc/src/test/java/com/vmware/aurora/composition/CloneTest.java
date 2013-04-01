/* **********************************************************************
 * Copyright 2010 VMware, Inc.  All rights reserved. VMware Confidential
 * **********************************************************************
 * $Id$
 * $DateTime$
 * $Change$
 * $Author$
 * *********************************************************************/

package com.vmware.aurora.composition;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.vmware.aurora.global.DiskSize;
import com.vmware.aurora.composition.ImportVmSP;
import com.vmware.aurora.composition.TestSP.CloneVmSP;
import com.vmware.aurora.composition.TestSP.TakeSnapshotSP;
import com.vmware.aurora.vc.DeviceId;
import com.vmware.aurora.vc.VcVirtualMachine.DiskCreateSpec;
import com.vmware.vim.binding.vim.vm.device.VirtualDiskOption.DiskMode;

/**
 * @author shuang
 *
 */
public class CloneTest extends AbstractTmTest {
   static final Logger logger = Logger.getLogger(CloneTest.class);

   /**
    * Test case :
    *
    * 1.Import the test vm.
    *
    * 2.Take a snapshot for the imported vm -- snap0.
    *
    * 3.Do two linked clones of snap0. One is "ClonedVM1",the other one is
    * "ClonedVM2".
    *
    * 4.The imported vm has two hard disks -- SCSI(0:0)Hard disk1 and
    * SCSI(0:1)Hard disk2.
    *
    * During the clone procedure of "ClonedVM1",I removed the SCSI(0:1)Hard
    * disk2 and added a new disk -- SCSI(0:2)Hard disk2.
    *
    * During the clone procedure of "ClonedVM2",I removed the SCSI(0:1)Hard
    * disk2 and added a new disk -- SCSI(0:3)Hard disk2.
    *
    * 5.Take a snapshot of "ClonedVM1" -- snap1.
    *
    * 6.Do a linked clone of snap1 and call the cloned vm "ClonedVM3".
    * "ClonedVM3" should have the same disk layout as "ClonedVM1".
    *
    */
   @Test
   public void testTransaction() throws Exception {
      DeviceId slot1 = new DeviceId("VirtualLsiLogicController", 0, 1);
      DeviceId slot2 = new DeviceId("VirtualLsiLogicController", 0, 2);
      DeviceId slot3 = new DeviceId("VirtualLsiLogicController", 0, 3);

      DeviceId[] removeDisks = { slot1 };

      DiskCreateSpec[] addDisks =
            { new DiskCreateSpec(slot2, ds, "data",
                  DiskMode.persistent, DiskSize.sizeFromGB(10)) };

      DiskCreateSpec[] addDisks1 =
            { new DiskCreateSpec(slot3, ds, "data",
                  DiskMode.persistent, DiskSize.sizeFromGB(20)) };


      //Import vm -- "PlatformTestVM" as the target test vm.
      ImportVmSP sp0 = new TestUtil().testImportVM(vmName, rp);

      //Take a snapshot for test vm -- snap0
      final String snapshotName = "snap";
      TakeSnapshotSP sp1 =
            new TestUtil().testTakeSnapshot(sp0.getResult().getId(), snapshotName, "snapshot of PlatformTestVM");

      //Clone from imported vm's snapshot -- "snap0".
      String newVmName1 = "clonedVM1";
      CloneVmSP sp2 =
            new TestUtil().testCloneVm(newVmName1, sp0.getResult().getId(),
                  snapshotName, rp, ds, removeDisks, addDisks);
      logger.info("Cloned VM: " + sp2.getResult());

      //Clone from "clonedVM1",first take a snapshot,then clone.
      String newVmName2 = "clonedVM2";
      CloneVmSP sp3 =
            new TestUtil().testCloneVm(newVmName2, sp0.getResult().getId(),
                  snapshotName, rp, ds, removeDisks, addDisks1);
      logger.info("Cloned VM: " + sp3.getResult());

      //Take a snapshot for "clonedVM1" -- snap1
      TakeSnapshotSP sp4 =
            new TestUtil().testTakeSnapshot(sp2.getResult(), snapshotName, "snapshot of clonedVM1");

      //Do a lined clone of "clonedVM1" using snapshot snap1.
      String newVmName3 = "clonedVM3";
      CloneVmSP sp5 =
            new TestUtil().testCloneVm(newVmName3, sp2.getResult(),
                  snapshotName, rp, ds, null, null);
      logger.info("Cloned VM: " + sp5.getResult());

      //Mark "ClonedVM1" for delete,but it won't be deleted until clonedVM3 is deleted.
      new TestUtil().testCleanupVm(sp2.getResult());
      logger.info("Deleted VM: " + sp2.getResult());

      //Mark "ClonedVM3" for delete,it should be deleted immediately.
      new TestUtil().testCleanupVm(sp5.getResult());
      logger.info("Deleted VM: " + sp5.getResult());

      new TestUtil().testCleanupVm(sp3.getResult());
      logger.info("Deleted VM: " + sp3.getResult());
   }
}
