/***************************************************************************
 * Copyright (c) 2012-2013 VMware, Inc. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ***************************************************************************/
package com.vmware.bdd.service.job;

import java.util.List;

import com.vmware.aurora.util.CmsWorker.PeriodicRequest;
import com.vmware.aurora.util.CmsWorker.WorkQueue;
import com.vmware.bdd.entity.ClusterEntity;
import com.vmware.bdd.manager.ClusterEntityManager;

public class ClusterNodeUpdator extends PeriodicRequest {
   
   private ClusterEntityManager entityMgr;
   
   public ClusterNodeUpdator(ClusterEntityManager entityMgr) {
      super(WorkQueue.VC_TASK_FIVE_MIN_DELAY);
      this.entityMgr = entityMgr;
   }

   protected boolean executeOnce() {
      List<ClusterEntity> clusters = entityMgr.findAllClusters();
      for (ClusterEntity cluster : clusters) {
         if (cluster.inStableStatus()) {
            syncUp(cluster.getName());
         }
      }
      return true;
   }

   public void syncUp(String clusterName) {
      entityMgr.syncUp(clusterName);
   }
}
