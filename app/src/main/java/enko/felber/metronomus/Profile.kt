package enko.felber.metronomus

class Profile(val pName: String, val pBpm: Int) {


    companion object {
        fun getProfileList(): List<Profile> {
            var profileList: ArrayList<Profile> = ArrayList()

            profileList.add(Profile("Test_1", 100))
            profileList.add(Profile("Test_2", 100))
            profileList.add(Profile("Test_3", 100))
            profileList.add(Profile("Test_4", 100))
            profileList.add(Profile("Test_5", 100))
            profileList.add(Profile("Test_6", 100))
            profileList.add(Profile("Test_7", 100))

            return profileList
        }
    }

}