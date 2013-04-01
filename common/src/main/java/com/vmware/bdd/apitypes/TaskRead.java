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
package com.vmware.bdd.apitypes;

/**
 * Task get output
 * 
 */
public class TaskRead {
   public enum Status {
      ABANDONED, STARTING, STARTED, STOPPED, STOPPING, COMPLETED, FAILED, UNKNOWN
   }
   public enum Type {
      INNER, VHM 
   }
   private Long id;
   private Status status;
   private Type type;
   private Double progress;
   private String errorMessage;
   private String workDir;
   private String progressMessage;
   private String target;

   public TaskRead() {

   }

   public TaskRead(Long id, Status status, Type type, Double progress, String errorMessage,
         String workDir, String progressMessage, String target) {
      this.id = id;
      this.status = status;
      this.type = type;
      this.progress = progress;
      this.errorMessage = errorMessage;
      this.workDir = workDir;
      this.progressMessage = progressMessage;
      this.target = target;
   }

   public String getProgressMessage() {
      return progressMessage;
   }

   public void setProgressMessage(String progressMessage) {
      this.progressMessage = progressMessage;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Status getStatus() {
      return status;
   }

   public void setStatus(Status status) {
      this.status = status;
   }

   public Type getType() {
      return type;
   }

   public void setType(Type type) {
      this.type = type;
   }

   public Double getProgress() {
      return progress;
   }

   public void setProgress(Double progress) {
      this.progress = progress;
   }

   public String getErrorMessage() {
      return errorMessage;
   }

   public void setErrorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
   }

   public String getWorkDir() {
      return workDir;
   }

   public void setWorkDir(String workDir) {
      this.workDir = workDir;
   }

   @Override
   public String toString() {
      return "TaskRead [id=" + id + ", status=" + status + ", type=" + type
            + ", progress=" + progress + ", errorMessage=" + errorMessage + ", workDir="
            + workDir + ", progressMessage=" + progressMessage + "]";
   }

   public String getTarget() {
      return target;
   }

   public void setTarget(String target) {
      this.target = target;
   }
}
