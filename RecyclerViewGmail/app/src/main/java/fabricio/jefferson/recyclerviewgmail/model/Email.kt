package fabricio.jefferson.recyclerviewgmail.model

data class Email (
    val user: String,
    val subject: String,
    val preview: String,
    val date: String,
    val stared: Boolean,
    val unread: Boolean,
    var selected: Boolean = false
)

class EmailBuilder{
    var user: String = ""
    var subject: String = ""
    var preview: String = ""
    var date: String = ""
    var stared: Boolean = false
    var unread: Boolean = false

    fun build(): Email = Email(user, subject, preview, date, stared, unread, false)
}

fun email(block: EmailBuilder.() -> Unit): Email = EmailBuilder().apply(block).build()

fun fakeEmails(): MutableList<Email> = mutableListOf(
    email {
        user = "Facebook"
        subject = "veja nossas 3 dicas principais.."
        preview = "Olá Jeffers"
        date = "01 Dez"
        stared = false
    },
    email {
        user = "Instagram"
        subject = "Kerolayne acabou de postar uma foto nova"
        preview = "Seu amigo postou uma foto nova"
        date = "02 Dez"
        stared = false
    },
    email {
        user = "Youtube"
        subject = "Ouça o novo som de Amiri."
        preview = "Ouça o novo disco de Amiri O.n.f.k"
        date = "01 Dez"
        stared = false
    },
    email {
        user = "Spotify"
        subject = "Ouça o novo som de Amiri no spotify"
        preview = "Ouça o novo disco do Rapper Amiri O.N.F.K"
        date = "01 Dez"
        stared = false
    },
    email {
        user = "Facebook"
        subject = "sua página teve 3 novas curtidas essa semana."
        preview = "Como tudo deve ser - Pág"
        date = "01 Dez"
        stared = false
    },
    email {
        user = "Twitter"
        subject = "Uma pessoa curtiu seu twitter."
        preview = "Fulano curtiu o seu twitter."
        date = "02 Dez"
        stared = false
    },
    email {
        user = "Twitter"
        subject = "Uma pessoa retwittou seu twitter."
        preview = "Fulano retwittou o seu twitter."
        date = "02 Dez"
        stared = false
    },
    email {
        user = "Google"
        subject = "Google dicas"
        preview = "Jefferson você precisa conferir essa dica que preparamos para você."
        date = "12 Dez"
        stared = false
    },
    email {
        user = "Amazon Prime Video"
        subject = "Novo catálogo de filmes e série"
        preview = "Venha ver os novos filmes e séries que foram adicionados ao prime videos."
        date = "10 Dez"
        stared = false
    },
    email {
        user = "Udemy"
        subject = "Começe já seu curso"
        preview = "Está na hora de começar o curso de desenvolvimento mobile."
        date = "10 Dez"
        stared = false
    },
    email {
        user = "Cesar"
        subject = "Hoje tem aula de Android Avançado"
        preview = "Está na hora de avançar seus conhecimentos em kotlin no curso de desenvolvimento mobile."
        date = " 02 Dez"
        stared = false
    }
    ,
    email {
        user = "Pitang"
        subject = "Amanhã tem entrega de Sprint"
        preview = "Jeffers lembre-se de preparar a apresentação para entrega de sprint amanhã"
        date = " 03 Dez"
        stared = false
    }
)