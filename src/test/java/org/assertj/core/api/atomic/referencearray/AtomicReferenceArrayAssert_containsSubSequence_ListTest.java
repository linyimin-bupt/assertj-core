/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2017 the original author or authors.
 */
package org.assertj.core.api.atomic.referencearray;

import org.assertj.core.api.AtomicReferenceArrayAssert;
import org.assertj.core.api.AtomicReferenceArrayAssertBaseTest;
import org.assertj.core.util.Lists;

import java.util.List;

import static org.assertj.core.util.Arrays.array;
import static org.mockito.Mockito.verify;

/**
 * Tests for <code>{@link AtomicReferenceArrayAssert#containsSubsequence(List)}</code>.
 *
 * @author Chris Arnott
 */
public class AtomicReferenceArrayAssert_containsSubSequence_ListTest extends AtomicReferenceArrayAssertBaseTest {

  @Override
  protected AtomicReferenceArrayAssert<Object> invoke_api_method() {
    // AtomicReferenceArrayAssertBaseTest is testing AtomicReferenceArray<Object>, so the List type needs to be Object
    // or the {@link AtomicReferenceArrayAssert#containsSequence(Object...)} method is called.
    return assertions.containsSubsequence(Lists.newArrayList((Object)"Luke", "Yoda"));
  }

  @Override
  protected void verify_internal_effects() {
    verify(arrays).assertContainsSubsequence(info(), internalArray(), array("Luke", "Yoda"));
  }
}