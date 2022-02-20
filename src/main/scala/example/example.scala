package example
import io.opentelemetry.api.trace.Span;
//import io.opentelemetry.extension.annotations.WithSpan

object Example {
  def main(args: Array[String]): Unit = {
    val span: Span = Span.current()
    span.setAttribute("data.example", "main")
    println("Hello main")
    (1 to 10).par.map {
      fuga(_)
    }
  }

  def fuga(i: Int): Unit = {
    val span: Span = Span.current()
    span.setAttribute("data.fuga.value", i)
    println("Hello fuga")
  }
}
