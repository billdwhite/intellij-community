/*
 * Copyright 2000-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.codeInsight.daemon;

import com.intellij.codeInspection.InspectionProfileEntry;
import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.compiler.JavacQuirksInspection;
import com.intellij.codeInspection.redundantCast.RedundantCastInspection;
import com.intellij.codeInspection.uncheckedWarnings.UncheckedWarningLocalInspection;
import com.intellij.codeInspection.unusedSymbol.UnusedSymbolLocalInspection;
import org.jetbrains.annotations.NonNls;

/**
 * This class is for "lightweight" tests only, i.e. those which can run inside default light project set up
 * For "heavyweight" tests use AdvHighlightingTest
 */
public class AmbiguousMethodCallTest extends LightDaemonAnalyzerTestCase {
  @NonNls static final String BASE_PATH = "/codeInsight/daemonCodeAnalyzer/ambiguousCalls";

  private void doTest(boolean checkWarnings, boolean checkInfos, InspectionProfileEntry... tools) throws Exception {
    for (InspectionProfileEntry tool : tools) { enableInspectionTool(tool); }
    doTest(BASE_PATH + "/" + getTestName(false) + ".java", checkWarnings, checkInfos);
  }

  private void doTest(boolean checkWarnings, boolean checkWeakWarnings, boolean checkInfos, InspectionProfileEntry... tools) throws Exception {
    for (InspectionProfileEntry tool : tools) { enableInspectionTool(tool); }
    doTest(BASE_PATH + "/" + getTestName(false) + ".java", checkWarnings, checkWeakWarnings, checkInfos);
  }

  @Override
  protected LocalInspectionTool[] configureLocalInspectionTools() {
    return new LocalInspectionTool[]{
      new UnusedSymbolLocalInspection(),
      new UncheckedWarningLocalInspection(),
      new JavacQuirksInspection(),
      new RedundantCastInspection()
    };
  }

  public void testBoxingAndStaticMethods() throws Exception {
    doTest(false, false);
  }

  public void testMultipleInheritance() throws Exception {
    doTest(false, false);
  }
}
