package qotd

import grails.transaction.Transactional

@Transactional
class QuoteService {

    def serviceMethod() {

    }

    def getStaticQuote()
    {
        return new Quote (author: "service Author" , content: " service Content")
    }
}
