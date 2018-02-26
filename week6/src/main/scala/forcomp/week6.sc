//import scala.io.Source
//object Tel2Sent {
//  val in = Source.fromURL("https://raw.githubusercontent.com/1ambda/scala/master/functional-progiramming-in-scala/src/main/scala/coursera/chapter6/linux.words")
//  val words = in.getLines().toList.filter(w => w forall (c => c.isLetter))
//  println(words)
//
//
//  val mnem = Map('2' -> "ABC",
//    '3' -> "DEF",
//    '4' -> "GHI",
//    '5' -> "JKL",
//    '6' -> "MNO",
//    '7' -> "PQRS",
//    '8' -> "TUV",
//    '9' -> "WXYZ"
//  )
//
//  val charCode: Map[Char, Char] =
//    for ((digit, str) <- mnem; ltr <- str) yield ltr -> digit
//
//  def wordCode(word: String): String = word.toUpperCase().map(charCode)
//
//  def wordsForNum: Map[String, Seq[String]] = words.groupBy(wordCode).withDefaultValue(Seq())
//
//  def encode(number: String): Set[List[String]] =
//    if (number.isEmpty) Set(List())
//    else {
//
//      for {
//        split <- 1 to number.length
//        word <- wordsForNum(number.take(split))
//        rest <- encode(number.drop(split))
//      } yield word :: rest
//    }.toSet
//
//  def translate(number: String): Set[String] =
//    encode(number).map(_.mkString(" "))
//
//  translate("7225247386")
//}

val OCC = List(('a', 2), ('b', 2))
type Occurrences = List[(Char, Int)]
//def combinations(occurrences: Occurrences): List[Occurrences] =
//  occurrences.foldRight(List[Occurrences](List()))((occ,acc) => acc ++ (
//    for {
//      comb <- acc
//      i <- 1 to occ._2
//    }yield (occ._1, i) :: comb)co
//  )

def combinations(occurrences: Occurrences): List[Occurrences] =
  occurrences match {
    case Nil => List(List())
    case (char, occ) :: xs =>
      for {
        z <- combinations(xs)
        n <- 0 to occ
      } yield if (n == 0) z else  (char, n) :: z
  }
combinations(OCC)