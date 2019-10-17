package app.vineshbuilds.calculator

class TokenizerImpl : ITokenizer {

    override fun tokenize(infixNotation: String): List<String> {
        val tokens = mutableListOf<String>()
        val stringBuilder = StringBuilder()

        fun flushIntoList() {
            if (stringBuilder.isNotBlank()) {
                tokens.add(stringBuilder.toString())
                stringBuilder.clear()
            }
        }

        infixNotation.toCharArray().forEach {
            when (it) {
                '+', '*', '/', '%' -> {
                    flushIntoList()
                    tokens.add("$it")
                }
                '-' -> {
                    flushIntoList()
                    if (tokens.lastOrNull()?.toDoubleOrNull() != null) {
                        tokens.add("$it")
                    } else {
                        //negative number
                        stringBuilder.append(it)
                    }
                }
                else -> stringBuilder.append(it)

            }
        }
        flushIntoList()
        return tokens
    }
}