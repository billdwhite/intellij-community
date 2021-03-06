/*
 * Copyright 2000-2011 JetBrains s.r.o.
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
package com.intellij.execution.testframework.sm.runner;

import com.intellij.execution.testframework.sm.runner.events.*;
import com.intellij.openapi.util.Key;
import com.intellij.testIntegration.TestLocationProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
* @author Roman.Chernyatchik
*/
public class MockGeneralTestEventsProcessorAdapter implements GeneralTestEventsProcessor {
  private final StringBuilder myOutputBuffer = new StringBuilder();

  @Override
  public void onStartTesting() {
  }

  @Override
  public void onTestsCountInSuite(int count) {
  }

  @Override
  public void onTestStarted(@NotNull TestStartedEvent testStartedEvent) {
  }

  @Override
  public void onTestFinished(@NotNull TestFinishedEvent testFinishedEvent) {
  }

  @Override
  public void onTestFailure(@NotNull TestFailedEvent testFailedEvent) {
  }

  @Override
  public void onTestIgnored(@NotNull TestIgnoredEvent testIgnoredEvent) {
  }

  @Override
  public void onTestOutput(@NotNull TestOutputEvent testOutputEvent) {
  }

  @Override
  public void onSuiteStarted(@NotNull TestSuiteStartedEvent suiteStartedEvent) {
  }

  @Override
  public void onSuiteFinished(@NotNull TestSuiteFinishedEvent suiteFinishedEvent) {
  }

  @Override
  public void onUncapturedOutput(@NotNull String text, Key outputType) {
    myOutputBuffer.append("[").append(outputType.toString()).append("]").append(text);
  }

  @Override
  public void onError(@NotNull String localizedMessage, @Nullable String stackTrace, boolean isCritical) {
  }

  @Override
  public void onCustomProgressTestsCategory(@Nullable String categoryName, int testCount) {
  }

  @Override
  public void onCustomProgressTestStarted() {
  }

  @Override
  public void onCustomProgressTestFailed() {
  }

  @Override
  public void onTestsReporterAttached() {
  }

  @Override
  public void setLocator(@NotNull TestLocationProvider locator) {
  }

  @Override
  public void addEventsListener(@NotNull SMTRunnerEventsListener viewer) {
  }

  @Override
  public void onFinishTesting() {
  }

  @Override
  public void setPrinterProvider(@NotNull TestProxyPrinterProvider printerProvider) {
  }

  @Override
  public void dispose() {
    myOutputBuffer.setLength(0);
  }

  public String getOutput() {
    return myOutputBuffer.toString();
  }
}
