package exercises

object Ex23Types extends App {
  trait TestEnvironment {
    val testName: String
  }

  class TestExecutor { test: TestEnvironment => // self можно называть по-другому
    def execute(): Unit = {
      println(s"Executing ${test.testName}")
    }
  }

  val aTest: TestExecutor = new TestExecutor with TestEnvironment {
    override val testName: String = "T-test"
  }

  aTest.execute()

}
