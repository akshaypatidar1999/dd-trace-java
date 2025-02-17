package datadog.trace.civisibility;

import datadog.trace.api.civisibility.config.SkippableTest;
import javax.annotation.Nullable;

/** Test module abstraction that is used by test framework instrumentations (e.g. JUnit, TestNG) */
public interface DDTestFrameworkModule {
  DDTestSuiteImpl testSuiteStart(
      String testSuiteName,
      @Nullable Class<?> testClass,
      @Nullable Long startTime,
      boolean parallelized);

  /**
   * Checks if a given test can be skipped with Intelligent Test Runner or not
   *
   * @param test Test to be checked
   * @return {@code true} if the test can be skipped, {@code false} otherwise
   */
  boolean isSkippable(SkippableTest test);

  /**
   * Checks if a given test can be skipped with Intelligent Test Runner or not. It the test is
   * considered skippable, the count of skippable tests is incremented.
   *
   * @param test Test to be checked
   * @return {@code true} if the test can be skipped, {@code false} otherwise
   */
  boolean skip(SkippableTest test);

  void end(Long startTime);
}
