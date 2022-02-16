package xyz.stylianosgakis.pawfinder.apollo.previewdata

import xyz.stylianosgakis.pawfinder.GetAnimalsQuery

fun GetAnimalsQuery.Companion.previewData(): GetAnimalsQuery.Data.Animal {
    return GetAnimalsQuery.Data.Animal(
        age = "Young",
        attributes = GetAnimalsQuery.Data.Animal.Attributes(
            declawed = false,
            houseTrained = true,
            shotsCurrent = true,
            spayedNeutered = true,
            specialNeeds = false
        ),
        breeds = GetAnimalsQuery.Data.Animal.Breeds(
            mixed = false,
            primary = "Domestic Short Hair ",
            secondary = null,
            unknown = false
        ),
        contact = GetAnimalsQuery.Data.Animal.Contact(
            address = "P.O. Box 201",
            city = "Broomall",
            country = "US",
            email = "4palsvolunteers@gmail.com",
            phone = "(610) 299-1860",
            postcode = "19008",
            state = "PA"
        ),
        description = "Coconut is a young adult who came in as a stray but he is so friendly. He's one of our...",
        gender = "Male",
        id = "54633582",
        links = GetAnimalsQuery.Data.Animal.Links(
            organization = GetAnimalsQuery.Data.Animal.Links.Organization(
                href = "/v2/organizations/pa82"
            ),
            self = GetAnimalsQuery.Data.Animal.Links.Self(
                href = "/v2/animals/54633582"
            ),
            type = GetAnimalsQuery.Data.Animal.Links.Type(
                href = "/v2/types/cat"
            )
        ),
        name = "Coconut",
        organizationAnimalId = "16828145",
        organizationId = "PA82",
        photos = emptyList(),
        primaryPhotoCropped = null,
        publishedAt = "2022-02-15T23:38:00+0000",
        size = "Medium",
        species = "Cat",
        status = "adoptable",
        statusChangedAt = "2022-02-15T23:38:00+0000",
        type = "Cat",
        url = "https://www.petfinder.com/cat/coconut-54633582/pa/broomall/p-dot-al-dot-s-pa82/?referrer_id=7be8c2c8-e1a0-4a6c-b728-a7742e45ed29"
    )
}
