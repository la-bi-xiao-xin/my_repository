package cn.itcast.demon

object Demo2 {
   class Person(){
    private var age:Int =_
    private var name:String =_
    private var sex:String =_
    //方法体返回一个代码的最后一行代码的值
    def getAge()={age}
    def setAge(age:Int){this.age=age}
    def getName()={name}
    def setName(name:String){this.name=name}
    def getSex()={sex}
    def setSex(sex:String)={this.sex=sex}
    private def getNameAandAge()={ name -> age }
  }

  def main(args: Array[String]): Unit = {
    val person = new Person
    person.setAge(25)
    person.setName("张三")
    person.setSex("男")
    val age = person.getAge()
    val name = person.getName()
    val sex = person.getSex()
    println(name + age + sex)
  }

}
