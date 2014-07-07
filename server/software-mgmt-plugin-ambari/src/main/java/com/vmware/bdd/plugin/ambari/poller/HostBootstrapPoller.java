/***************************************************************************
 * Copyright (c) 2014 VMware, Inc. All Rights Reserved.
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
package com.vmware.bdd.plugin.ambari.poller;

import com.vmware.bdd.plugin.ambari.api.manager.ApiManager;
import com.vmware.bdd.plugin.ambari.api.model.ApiBootstrap;
import com.vmware.bdd.plugin.ambari.api.model.ApiBootstrapStatus;
import com.vmware.bdd.plugin.ambari.api.model.BootstrapStatus;
import com.vmware.bdd.software.mgmt.plugin.monitor.ClusterReport;
import com.vmware.bdd.software.mgmt.plugin.monitor.ClusterReportQueue;
import com.vmware.bdd.software.mgmt.plugin.monitor.StatusPoller;

public class HostBootstrapPoller extends StatusPoller {

   private ApiManager apiManager;
   private ApiBootstrap apiBootstrap;
   private ClusterReport currentReport;
   private ClusterReportQueue reportQueue;
   private int endProgress;

   public HostBootstrapPoller(final ApiManager apiManager,
         final ApiBootstrap apiBootstrap, final ClusterReport currentReport,
         final ClusterReportQueue reportQueue, int endProgress) {
      this.apiManager = apiManager;
      this.apiBootstrap = apiBootstrap;
      this.currentReport = currentReport;
      this.reportQueue = reportQueue;
      this.endProgress = endProgress;
   }

   @Override
   public boolean poll() {
      ApiBootstrapStatus apiBootstrapStatus =
            apiManager.bootstrapStatus(apiBootstrap.getRequestId());

      BootstrapStatus bootstrapStatus =
            BootstrapStatus.valueOf(apiBootstrapStatus.getStatus());
      if (bootstrapStatus.isCompletedState()) {
         currentReport.setProgress(endProgress);
         reportQueue.addClusterReport(currentReport.clone());
         return true;
      }

      return false;
   }

}
