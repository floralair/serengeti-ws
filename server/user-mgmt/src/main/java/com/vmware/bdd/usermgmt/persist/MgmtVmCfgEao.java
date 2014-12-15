/******************************************************************************
 *   Copyright (c) 2014 VMware, Inc. All Rights Reserved.
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *****************************************************************************/
package com.vmware.bdd.usermgmt.persist;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.vmware.bdd.usermgmt.UserMgmtConstants;

/**
 * @TODO add persistence
 * Created By xiaoliangl on 11/28/14.
 */
@Component
public class MgmtVmCfgEao {

   HashMap<String, String> cfg1 = new HashMap<>();


   public MgmtVmCfgEao() {
      cfg1.put(UserMgmtConstants.VMCONFIG_MGMTVM_CUM_MODE, "LOCAL"); //mixed, ldap
      cfg1.put(UserMgmtConstants.VMCONFIG_MGMTVM_CUM_SERVERNAME, "");
   }

   public Map<String, String> findAll() {
      return cfg1;
   }

   public void update(Map<String, String> newConfig) {
      if(newConfig != null) {
         cfg1.putAll(newConfig);
      }
   }
}
