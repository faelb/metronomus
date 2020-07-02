package enko.felber.metronomus

class Profile(val pName: String, val pBpm: Int) {


    companion object {
        fun getProfileList(): List<Profile> {
            var profileList: ArrayList<Profile> = ArrayList()

            profileList.add(Profile("Largo", 50))
            profileList.add(Profile("Larghetto", 65))
            profileList.add(Profile("Adagio", 70))
            profileList.add(Profile("Andante", 90))
            profileList.add(Profile("Moderato", 110))
            profileList.add(Profile("Allegro", 130))
            profileList.add(Profile("Presto", 180))
            profileList.add(Profile("Prestissimo", 200))

            return profileList
        }
    }

}