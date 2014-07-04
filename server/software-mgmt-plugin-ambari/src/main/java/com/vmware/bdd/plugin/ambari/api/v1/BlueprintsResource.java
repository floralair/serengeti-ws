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
package com.vmware.bdd.plugin.ambari.api.v1;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static com.vmware.bdd.plugin.ambari.api.Parameters.BLUEPRINT_NAME;

@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
public interface BlueprintsResource {

   @GET
   @Path("/")
   public String readBlueprints();

   @GET
   @Path("/{blueprintName}")
   public String readBlueprint(@PathParam(BLUEPRINT_NAME) String blueprintName);

   @POST
   @Path("/{blueprintName}")
   @Consumes({ MediaType.APPLICATION_XML })
   public String createBlueprint(@PathParam(BLUEPRINT_NAME) String blueprintName, String blueprint);

}