package common.types

trait NativeOrdered[T] extends Ordered[T] {
    override def compare(that: T): Int = this.toString.compareTo(that.toString)
}
