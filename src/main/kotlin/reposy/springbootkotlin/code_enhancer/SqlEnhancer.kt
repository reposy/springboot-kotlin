package reposy.springbootkotlin.code_enhancer

import org.springframework.stereotype.Component

@Component
class SqlEnhancer {

    fun enhanceReadability(inputSql: String): String {

        /**
         * 1. String to List<String>
         * - 어절 단위로 나눔
         * - 두 개 이상의 공백, 개행(\n), 들여쓰기(\t)를 하나의 공백으로 변경
         *      * 단, 따옴표 안의 문자의 경우 하나의 공백으로 처리하지 않음
         * 2. 재조립
         */
        return ""
    }

    fun processSqlForSplit(sql: String): List<String> {

        val result = ArrayList<String>()

        var isInQuote = false
        var openParenthesesCount = 0 // '(': +1, ')': -1
        var openSquareBracketsCount = 0 // '[': +1, ']': -1
        var continuousSpaceCount = 0

        var left = 0
        for ( right in sql.indices ) {
            val c = sql[right]
            if ( isInQuote ) { // 문자열 내의 경우
                if ( c == '\'' ) { // 문자열이 종료에 다다랐을 경우
                    isInQuote = false
                    val tempStr = sql.substring(left, right + 1)
                    if (tempStr.trim().isNotEmpty())
                        result.add(tempStr)
                    left = right + 1
                }
            }
            else { // 문자열 밖
                if ( c in listOf(' ', '\n', '\t') ) {
                    if ( right == sql.lastIndex ) { // 마지막 문자가 공백인 경우
                        val tempStr = sql.substring(left, right + 1)
                        if (tempStr.trim().isNotEmpty())
                            result.add(tempStr)
                    }
                }
                else {
                    if ( continuousSpaceCount > 0 ) {
                        result.add(sql.substring(left, right - continuousSpaceCount))
                        continuousSpaceCount = 0
                        left = right
                    } // if
                    else {
                        continuousSpaceCount = 0
                        when(c) {
                            '\'' -> isInQuote = true
                            '(' -> openParenthesesCount++
                            ')' -> openParenthesesCount--
                            '[' -> openSquareBracketsCount++
                            ']' -> openSquareBracketsCount--
                            ' ', '\n', '\t' -> {
                                continuousSpaceCount++
                            }
                        } // else-when
                    } // else-else
                } // else

            }

        } // for ( right in sql.indices )

        return result
    }

    fun splitIntoWords(input: String): List<String> {




        return arrayListOf()
    }
}