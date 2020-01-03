package app.vineshbuilds.calculator

import app.vineshbuilds.calculator.tokens.Token

interface ITokenizer {
    /**
     * Tokenizes the given input
     *
     * @param infixNotation normal mathematical expression eg: 2+3*-7
     * @return A list of tokens eg: [2,add,3,mul,neg,7]
     */
    fun tokenize(infixNotation: String): List<Token>
}