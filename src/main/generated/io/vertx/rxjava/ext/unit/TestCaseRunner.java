/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.rxjava.ext.unit;

import io.vertx.ext.unit.TestCaseReport;
import io.vertx.core.Handler;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 *
 * NOTE: This class has been automatically generated from the original non RX-ified interface using Vert.x codegen.
 */

public class TestCaseRunner {

  final TestCaseReport delegate;

  public TestCaseRunner(TestCaseReport delegate) {
    this.delegate = delegate;
  }

  public Object getDelegate() {
    return delegate;
  }

  /**
   * @return the test case name
   */
  public String name() {
    if (cached_0 != null) {
      return cached_0;
    }
    String ret = this.delegate.name();
    cached_0 = ret;
    return ret;
  }

  /**
   * Set a callback for completion, the specified {@code handler} is invoked when the test exec has completed.
   *
   * @param handler the completion handler
   */
  public void endHandler(Handler<TestResult> handler) {
    this.delegate.endHandler(new Handler<io.vertx.ext.unit.TestResult>() {
      public void handle(io.vertx.ext.unit.TestResult event) {
        handler.handle(new TestResult(event));
      }
    });
  }

  private java.lang.String cached_0;

  public static TestCaseRunner newInstance(TestCaseReport arg) {
    return new TestCaseRunner(arg);
  }
}
