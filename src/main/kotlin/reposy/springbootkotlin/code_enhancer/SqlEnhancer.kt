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

    fun processSqlForSplit(sql: String): String {

        val result = StringBuilder()

        var isInQuote = false
        var openBracketCount = 0
        var left = 0
        for ( right in sql.indices ) {
            val c = sql[right]
            when(c) {
                '\'' -> {
                    isInQuote = !isInQuote
                    if (!isInQuote) {
                        result.append(sql.substring(left, right+1))
                        left = right + 1
                    }
                }
                '(' -> {
                    if(!isInQuote)
                        openBracketCount++
                }
                ')' -> {
                    if(!isInQuote)
                        openBracketCount--
                }
                '\n', '\t' -> {
                    if ( left < right ) {

                    }
                    result.append(' ')

                    left = right + 1
                }

            }
            if ( !isInQuote && openBracketCount == 0 ) {

            }
        }

        return result.toString()
    }

    fun splitIntoWords(input: String): List<String> {




        return arrayListOf()
    }
}