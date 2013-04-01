/************************************************************
 * Copyright (c) 2011 VMware, Inc.  All rights reserved.
 ************************************************************/

package com.vmware.aurora.composition;

import java.io.FileInputStream;
import java.util.Properties;

import com.google.gson.internal.Pair;
import com.vmware.aurora.vc.VcCluster;
import com.vmware.aurora.vc.VcDatacenter;
import com.vmware.aurora.vc.VcDatastore;
import com.vmware.aurora.vc.VcInventory;
import com.vmware.aurora.vc.VcResourcePool;

/**
 * Configurations for junit testing. The global variables are setup by settings
 * in test.properties. To avoid conflicts in running junit tests, it's better
 * to override the default settings.
 */
public class VcTestConfig {
   /**
    * Path to resource pool used for testing. It's expected to be pre-created in VC.
    */
   public static String testRpPath;

   /**
    * Postfix used for creating unique names for VM, RP, etc. in test runs.
    */
   public static String testPostfix;

   public static String testDsName;

   /**
    * Path to the ovf to be uploaded as VM template
    */
   public static String ovfPath = "./src/test/resources/aurora_dbvm-OVF10.ovf";

   public static String testVmFolderName;

   static {
      try {
         init();
      } catch (Exception e) {
         System.out.println("VcTestConfig init failure");
         e.printStackTrace();
      }
   }

   public static Pair<VcDatacenter, VcResourcePool> getTestRPAndDC() throws Exception {
      VcResourcePool testRP = null;
      VcDatacenter testDC = null;

      for(VcDatacenter dc : VcInventory.getDatacenters()) {
         testDC = dc;
         for(VcCluster cluster : dc.getVcClusters()) {
            testRP = cluster.searchRP(VcTestConfig.testRpPath);
            if (testRP != null) {
               break;
            }
         }
      }

      if (testRP == null) {
         throw new Exception("cannot find test rp:" + VcTestConfig.testRpPath);
      }
      return new Pair<VcDatacenter, VcResourcePool>(testDC, testRP);
   }

   public static VcDatastore getTestDS() throws Exception {
      for (VcCluster cluster : VcInventory.getClusters()) {
         for (VcDatastore ds : cluster.getSharedDatastores()) {
            if (ds.getName().equals(testDsName)) {
               return ds;
            }
         }
      }
      throw new Exception("cannot find test ds");
   }

   public static void init() throws Exception {
      Properties properties = new Properties();
      FileInputStream in = new FileInputStream("./src/test/resources/test.properties");
      properties.load(in);
      in.close();

      testRpPath = properties.getProperty("testRpPath");
      testPostfix = properties.getProperty("testPostfix");
      testDsName = properties.getProperty("testDsName");
      testVmFolderName = properties.getProperty("testVmFolderName");
   }
}
