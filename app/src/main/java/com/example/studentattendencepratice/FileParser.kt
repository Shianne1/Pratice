package com.example.studentattendencepratice

object FileParser {
    private val alphabet1 = arrayListOf<String>(
        "A", "B", "C","D","E","F","G","H","I","J","K","L",
        "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
    )

    fun PopulateLetter(studentNames: ArrayList<StudentNames>): ArrayList<SortingNames>{
        val alphabet = ArrayList<String>()
        alphabet.add("A")
        alphabet.add("B")
        alphabet.add("C")
        alphabet.add("D")
        alphabet.add("E")
        alphabet.add("F")
        alphabet.add("G")
        alphabet.add("H")
        alphabet.add("I")
        alphabet.add("J")
        alphabet.add("K")
        alphabet.add("L")
        alphabet.add("M")
        alphabet.add("N")
        alphabet.add("O")
        alphabet.add("P")
        alphabet.add("Q")
        alphabet.add("R")
        alphabet.add("S")
        alphabet.add("T")
        alphabet.add("U")
        alphabet.add("V")
        alphabet.add("W")
        alphabet.add("X")
        alphabet.add("Y")
        alphabet.add("Z")

        val sortingNames = ArrayList<SortingNames>()
        /*
        for(studentLetter in studentNames) {
            if(sortingNames.isEmpty()){
                val newSortingNames = SortingNames(studentLetter.names.first().toString(),ArrayList())
                newSortingNames.students.add(studentLetter)
                sortingNames.add(newSortingNames)
            }
            else {
                for(letter in alphabet){
                    if(alphabet.letter.equals(studentLetter.names.first().toString(), true)){
                        sortingNames.add(SortingNames(studentLetter.names.first().toString(),ArrayList()))
                    }
                }
            }
            studentLetter.names.first()
        }

         */
        return sortingNames
    }
}