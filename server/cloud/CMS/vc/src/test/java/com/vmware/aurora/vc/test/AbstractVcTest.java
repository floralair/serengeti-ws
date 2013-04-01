/************************************************************
 * Copyright (c) 2011 VMware, Inc.  All rights reserved.
 ************************************************************/
package com.vmware.aurora.vc.test;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.vmware.aurora.global.Configuration;
import com.vmware.aurora.vc.VcInventory;
import com.vmware.aurora.vc.vcservice.VcContext;
import com.vmware.aurora.vc.vcservice.VcService;
import com.vmware.aurora.vc.vcservice.VcSession;

abstract public class AbstractVcTest {

   static Properties properties;
   static String singleVcUrl;
   static String singleVcUserName;
   static String singleVcPassword;
   static String locale;

   protected static VcService vcService;

   @BeforeClass
   public static void onSetUp() throws Exception {
      if (properties != null) {
         return;
      }

      try {
         properties = new Properties();
         FileInputStream in = new FileInputStream("./src/test/resources/test.properties");
         properties.load(in);
         in.close();

         singleVcUrl = properties.getProperty("singleVcUrl");
         singleVcUserName = properties.getProperty("singleVcUserName");
         singleVcPassword = properties.getProperty("singleVcPassword");
         locale = properties.getProperty("locale");
         VcTestConfig.testRpPath = properties.getProperty("testRpPath");
         VcTestConfig.testPostfix = properties.getProperty("testPostfix");
         VcTestConfig.testFilePath = properties.getProperty("testFilePath");
         VcTestConfig.testDsName = properties.getProperty("testDsName");
         Configuration.approveBootstrapInstanceId(Configuration.BootstrapUsage.ALLOWED);
         Configuration.approveBootstrapInstanceId(Configuration.BootstrapUsage.FINALIZED);

         VcContext.initVcContext();
         VcSession<Void> session = new VcSession<Void>() {
            protected boolean isTaskSession() {
               return true;
            }
            public Void body() throws Exception {
               return null;
            }
         };
         VcContext.startSession(session);
         vcService = VcContext.getService();

         in = new FileInputStream("./src/test/resources/aurora-cms.properties");
         properties.load(in);
         in.close();

         VcInventory.loadInventory();
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   @AfterClass
   public static void onTearDown() throws Exception {
      VcContext.endSession();
      VcContext.shutdown();
   }
}
