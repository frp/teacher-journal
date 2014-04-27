package ua.kpi.teacherjournal

import org.scaloid.common._
import android.graphics.Color

class MainActivity extends SActivity {

  private val headerColor = Color.rgb(0xe7, 0xe7, 0xe7)
  private val cellColor = Color.WHITE;
  private val borderColor = Color.rgb(0xcc, 0xcc, 0xcc)

  onCreate {

    import StudentDAO._

    contentView = new SVerticalLayout {

      style {
        case t: STextView => t.textColor(Color.BLACK)
      }

      this += new SScrollView {
        this += new STableLayout {
          // Header row
          this += new STableRow {
            STextView(group).backgroundColor(headerColor).<<.marginRight(1).marginBottom(1).>>
            for (date <- dates)
              STextView(date).backgroundColor(headerColor).<<.marginRight(1).marginBottom(1).>>
          }
          // Student rows
          for (student <- students.zipWithIndex)
            this += new STableRow {
              STextView((student._2 + 1) + ". " + student._1.name).backgroundColor(headerColor).<<.
                marginRight(1).marginBottom(1).>>
              for (date <- dates)
                STextView(student._1.marks.getOrElse(date, "")).backgroundColor(cellColor).<<.marginRight(1).
                  marginBottom(1).>>
            }
        }
      }
    }.backgroundColor(Color.RED)
  }
}
