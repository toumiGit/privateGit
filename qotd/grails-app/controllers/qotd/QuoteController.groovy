package qotd

class QuoteController {

    def scaffold=true

    def index() { redirect (action:home)}

    def home = { render " <h1> Real programmers do not eat </h1> "}

//    def random = {
//        def staticAuthor = "anonymous"
//        def staticContent=" real programmers don t eat quoche"
//        [ author : staticAuthor , content : staticContent ]
//    }

    def random = {

        for (int i=1;i<2230825;i++)
        {
            println i;
        }

        def staticQuote = new Quote(author: "Anonymous",
                content: "Real Programmers Don't eat")
        def test="test"
        def staticAuthor = "anonymous"
        [ quote : staticQuote , test : test , author : staticAuthor]
    }

    def staticQuote =
            {
                def x = QuoteService.getStaticQuote()
                [quote : x]
            }

    def random2= {

        for (int i=1;i<223082;i++)
        {
            println " --- " + i;
        }

        new Quote(author: "test",
                content: "test").save();
        new Quote(author: "test",
                content: "test2").save();
        def allQuotes = Quote.list();
        println allQuotes.content
        def randomQuote
        if (allQuotes.size() > 0)
        {
            def randomIdx = new Random().nextInt(allQuotes.size())
            randomQuote = allQuotes [randomIdx];
        }
        else
        {
            randomQuote = new Quote(author: "Anonymous",
                    content: "Real Programmers Don't eat quiche")
        }

        [quote: randomQuote ]
    }

}
