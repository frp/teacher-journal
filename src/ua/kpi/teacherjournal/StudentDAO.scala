package ua.kpi.teacherjournal

object StudentDAO {
  val group = "IO-25"
  val students = for (i <- 1 to 50) yield Student("Student " + i.toString, Map[String, String]("17.02" -> "3"))
  val dates = Array("17.02", "24.02", "1.03", "8.03", "15.03", "Lab 1", "Lab 2")
}
