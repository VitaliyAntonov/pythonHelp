import java.awt.Point
import java.beans

/**
 *  Спецификация JavaBeans включает понятие обработчика события изменения
 *  свойства (property change listener) – стандартный способ организации взаимодействий между компонентами
 *  посредством изменения их свойств. Класс PropertyChangeSupport является
 *  суперклассом для любых компонентов, желающих обеспечить поддержку обработчиков событий изменений свойств.
 *  К сожалению, класс, который уже наследует другой суперкласс, такой как JComponent,
 *  должен повторно реализовать методы. Определите свою реализацию PropertyChangeSupport
 *  в виде трейта и подмешайте его в класс java.awt.Point.
 */
object Exercise_5 extends App {
  trait PropertyChangeSupport{
    val pcs = new beans.PropertyChangeSupport(this)
    def addPropertyChangeListener(listener: java.beans.PropertyChangeListener) =
      this.pcs.addPropertyChangeListener(listener)
    def removePropertyChangeListener(listener: java.beans.PropertyChangeListener) =
      this.pcs.removePropertyChangeListener(listener)
    def firePropertyChange(propertyName: String, oldValue: Any, newValue: Any) ={
      println(propertyName, oldValue.toString, newValue.toString)
      pcs.firePropertyChange(propertyName, oldValue, newValue)
    }
  }
  class BeanPoint extends java.awt.Point with PropertyChangeSupport{
    override def setLocation(x: Int, y: Int): Unit = {
      firePropertyChange("setLocation", getLocation, new Point(x, y))
      super.setLocation(x, y)
    }
    override def move(x: Int, y: Int): Unit = {
      firePropertyChange("move", getLocation, new Point(x, y))
      super.move(x, y)
    }
    override def translate(dx: Int, dy: Int): Unit = {
      firePropertyChange("translate", getLocation, new Point(x + dx, y + dy))
      super.translate(dx, dy)
    }
  }
  val point = new BeanPoint()
  point.setLocation(5, 5)
  point.translate(1,1)
  point.move(5,5)
}
