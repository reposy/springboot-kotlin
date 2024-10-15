package reposy.springbootkotlin.code_enhancer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SqlEnhancerTest {

    lateinit var sqlEnhancer: SqlEnhancer

    @BeforeEach
    fun setup() {
        sqlEnhancer = SqlEnhancer()
    }

    @Test
    fun `Test enhanceReadability(String) case1-Basic_1 TABLE`() {
        // given
        val sql = """
           SELECT
               MEMBER_ID,
               COUNT(*)
           FROM
               MEMBER
           WHERE
               MEMBER_NAME LIKE CONCAT('%', 'sypg', '%')
           GROUP BY
               MEMBER_ID
           ORDER BY
               MEMBER_ID
        """

        // when
        val result = sqlEnhancer.enhanceReadability(sql)

        val expected = """
            SELECT MEMBER_ID
                 , COUNT(*)
              FROM MEMBER
             WHERE MEMBER_NAME LIKE CONCAT('%', 'sypg', '%')
          GROUP BY MEMBER_ID
          ORDER BY MEMBER_ID DESC
                 , MEMBER_NAME
        """
        // then
        assertThat(expected).isEqualTo(result)
    }
}