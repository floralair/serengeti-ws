/***************************************************************************
 * Copyright (c) 2014-2015 VMware, Inc. All Rights Reserved.
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
package com.vmware.bdd.plugin.ambari.service.am;

import javax.ws.rs.core.Response;

import com.vmware.bdd.plugin.ambari.api.v1.resource.stacks2.ComponentsResource;

public class FakeComponentsResource implements ComponentsResource {

   private String stackVersion;

   public FakeComponentsResource(String stackVersion) {
      this.stackVersion = stackVersion;
   }

   @Override
   public Response readComponents() {
      return BuildResponse.buildResponse("stacks/versions/" + stackVersion
            + "/stackServices/components/components.json");
   }

   @Override
   public Response readComponentsWithFilter(String fields) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Response readComponent(String componentName) {
      return BuildResponse.buildResponse("stacks/versions/" + stackVersion
            + "/stackServices/components/DATANODE_component.json");
   }

}
