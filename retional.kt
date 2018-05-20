class Retional(n: Int, d: Int) {
  init {
    require(d != 0, {"denominator must not be null"})
  }
  private val g by lazy { gcd(Math.abs(n), Math.abs(d)) }
  val numerator: Int by lazy { n / g }
  val denominator: Int by lazy { d / g }
  fun plus(that: Retional): Retional =
    Retional(
      numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator
    )
  override fun toString(): String = "${numerator}/${denominator}"
  tailrec private fun gcd(a: Int, b: Int): Int =
    if (b == 0) a
    else gcd(b, a % b)
}
