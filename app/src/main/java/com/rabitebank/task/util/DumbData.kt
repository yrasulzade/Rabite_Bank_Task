package com.rabitebank.task.util

import com.rabitebank.task.model.*

object DumbData {

    fun getFrequentlyChattedUsers(): ArrayList<FrequentlyChattedUser> {
        val frequentlyChatterUsers = ArrayList<FrequentlyChattedUser>()
        frequentlyChatterUsers.add(
            FrequentlyChattedUser(
                "Frank",
                "https://i.insider.com/5484d9d1eab8ea3017b17e29?width=600&format=jpeg&auto=webp"
            )
        )
        frequentlyChatterUsers.add(
            FrequentlyChattedUser(
                "Marta",
                "https://sa1s3optim.patientpop.com/assets/images/provider/photos/1888657.jpg"
            )
        )
        frequentlyChatterUsers.add(
            FrequentlyChattedUser(
                "Frank",
                "https://i.insider.com/5484d9d1eab8ea3017b17e29?width=600&format=jpeg&auto=webp"
            )
        )
        frequentlyChatterUsers.add(
            FrequentlyChattedUser(
                "Theressa",
                "https://img.freepik.com/free-photo/young-handsome-man-with-beard-isolated-keeping-arms-crossed-frontal-position_1368-132662.jpg?size=626&ext=jpg"
            )
        )
        frequentlyChatterUsers.add(
            FrequentlyChattedUser(
                "Francis",
                "https://i.insider.com/5484d9d1eab8ea3017b17e29?width=600&format=jpeg&auto=webp"
            )
        )

        frequentlyChatterUsers.add(
            FrequentlyChattedUser(
                "Marta",
                "https://sa1s3optim.patientpop.com/assets/images/provider/photos/1888657.jpg"
            )
        )
        frequentlyChatterUsers.add(
            FrequentlyChattedUser(
                "Frank",
                "https://i.insider.com/5484d9d1eab8ea3017b17e29?width=600&format=jpeg&auto=webp"
            )
        )

        return frequentlyChatterUsers
    }

    fun getMessagesBetweenTwoUser(): ArrayList<Message> {
        val messages = ArrayList<Message>()

        messages.add(Message("This is a message 1", true, MessageType.TEXT))
        messages.add(Message("This is a message 2", false, MessageType.TEXT))
        messages.add(Message("This is a message 3", true, MessageType.TEXT))
        messages.add(Message("This is a message 4", true, MessageType.TEXT))
        messages.add(Message("This is a message 5", false, MessageType.TEXT))
        messages.add(
            Message(
                "https://i.insider.com/5484d9d1eab8ea3017b17e29?width=600&format=jpeg&auto=webp",
                true,
                MessageType.IMAGE
            )
        )
        messages.add(Message("This is a message 6", true, MessageType.TEXT))

        return messages
    }

    fun getLatestMessages(): ArrayList<ChatDialogMessage> {
        val messages = ArrayList<ChatDialogMessage>()

        messages.add(
            ChatDialogMessage(
                "Insta Mobile Team", "This Flutter app rocks", "11:13 AM",
                listOf(
                    "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cGVyc29ufGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80",
                    "https://live-production.wcms.abc-cdn.net.au/75f8d2a8bd8fcd3294ddde805a653f5f?impolicy=wcms_crop_resize&cropH=665&cropW=1000&xPos=0&yPos=0&width=862&height=575"
                ),
                DialogMessageType.GROUP_CHAT
            )
        )

        messages.add(
            ChatDialogMessage(
                "Frank Martin",
                "Group chat, videos, wow",
                "11:15 AM",
                listOf("https://media.istockphoto.com/photos/smiling-indian-man-looking-at-camera-picture-id1270067126?b=1&k=6&m=1270067126&s=170667a&w=0&h=ORPL0Z6kn8TSL3ObkcvmGB8wU5v2BI_1ZnLEiFUI32U="),
                DialogMessageType.SINGLE_CHAT
            )
        )

        messages.add(
            ChatDialogMessage(
                "Frank",
                "It took 4 months of development",
                "06:00 AM",
                listOf("https://sa1s3optim.patientpop.com/assets/images/provider/photos/1888657.jpg"),
                DialogMessageType.SINGLE_CHAT
            )
        )

        messages.add(
            ChatDialogMessage(
                "Marta Johnson",
                "Why were you late?",
                "19:08 AM",
                listOf("https://i.insider.com/5484d9d1eab8ea3017b17e29?width=600&format=jpeg&auto=webp"),
                DialogMessageType.SINGLE_CHAT
            )
        )

        messages.add(
            ChatDialogMessage(
                "Frank",
                "Wow, this is amazing",
                "18:15 PM",
                listOf("https://sa1s3optim.patientpop.com/assets/images/provider/photos/1888657.jpg"),
                DialogMessageType.SINGLE_CHAT
            )
        )

        messages.add(
            ChatDialogMessage(
                "Francis Soprano",
                "Mark sent a video",
                "14:45 AM",
                listOf("https://variety.com/wp-content/uploads/2021/03/Ryan-Gosling.jpg?w=681&h=383&crop=1"),
                DialogMessageType.SINGLE_CHAT
            )
        )

        messages.add(
            ChatDialogMessage(
                "Jose Gonzalez",
                "Hello, where are you",
                "14:50 PM",
                listOf("https://img.freepik.com/free-photo/waist-up-portrait-handsome-serious-unshaven-male-keeps-hands-together-dressed-dark-blue-shirt-has-talk-with-interlocutor-stands-against-white-wall-self-confident-man-freelancer_273609-16320.jpg?size=626&ext=jpg&ga=GA1.2.1592312461.1615680000"),
                DialogMessageType.SINGLE_CHAT
            )
        )

        messages.add(
            ChatDialogMessage(
                "The group chat", "Halo amigos", "02:18 AM",
                listOf(
                    "https://thumbs.dreamstime.com/b/man-top-mountain-looking-view-guy-mountains-landscape-120551228.jpg",
                    "https://live-production.wcms.abc-cdn.net.au/75f8d2a8bd8fcd3294ddde805a653f5f?impolicy=wcms_crop_resize&cropH=665&cropW=1000&xPos=0&yPos=0&width=862&height=575"
                ), DialogMessageType.GROUP_CHAT
            )
        )

        messages.add(
            ChatDialogMessage(
                "Marta Popaes",
                "There are so many features here",
                "19:08 AM",
                listOf("https://i.insider.com/5484d9d1eab8ea3017b17e29?width=600&format=jpeg&auto=webp"),
                DialogMessageType.SINGLE_CHAT
            )
        )

        messages.add(
            ChatDialogMessage(
                "Frank",
                "Wow, this is crazy",
                "18:15 PM",
                listOf("https://sa1s3optim.patientpop.com/assets/images/provider/photos/1888657.jpg"),
                DialogMessageType.SINGLE_CHAT
            )
        )

        messages.add(
            ChatDialogMessage(
                "Francis Soprano",
                "Mark sent a video",
                "14:45 AM",
                listOf("https://variety.com/wp-content/uploads/2021/03/Ryan-Gosling.jpg?w=681&h=383&crop=1"),
                DialogMessageType.SINGLE_CHAT
            )
        )

        messages.add(
            ChatDialogMessage(
                "Jose Gonzalez",
                "Hello",
                "06:55 PM",
                listOf("https://img.freepik.com/free-photo/waist-up-portrait-handsome-serious-unshaven-male-keeps-hands-together-dressed-dark-blue-shirt-has-talk-with-interlocutor-stands-against-white-wall-self-confident-man-freelancer_273609-16320.jpg?size=626&ext=jpg&ga=GA1.2.1592312461.1615680000"),
                DialogMessageType.SINGLE_CHAT
            )
        )

        messages.add(
            ChatDialogMessage(
                "My amigos", "Halo amigos", "10:00 AM",
                listOf(
                    "https://thumbs.dreamstime.com/b/man-top-mountain-looking-view-guy-mountains-landscape-120551228.jpg",
                    "https://live-production.wcms.abc-cdn.net.au/75f8d2a8bd8fcd3294ddde805a653f5f?impolicy=wcms_crop_resize&cropH=665&cropW=1000&xPos=0&yPos=0&width=862&height=575"
                ), DialogMessageType.GROUP_CHAT
            )
        )

        return messages
    }
}