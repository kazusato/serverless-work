package kazusato.work.serverless.movie

import com.amazonaws.services.lambda.runtime.Context
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec
import org.mockito.Mockito.mock

class GetMovieInfoTest : StringSpec() {
    init {
        "GetMovieInfo function must return a correct response" {
            val req = MovieInfoRequest()
            req.year = 2099
            req.title = "hello world"

            val resp = GetMovieInfo().handleRequest(req, mock(Context::class.java))
            resp.year shouldBe 2099
            resp.title shouldBe "hello world"
        }
    }
}