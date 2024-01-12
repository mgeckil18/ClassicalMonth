package com.example.classicalmonth
data class ClassicalMusicPiece(
    val id: Int,
    val title: String,
    val composer: String,
    val performer: String,
    val duration: String
)

// Example list of classical music pieces
val classicalMusicDatabase = listOf(
    ClassicalMusicPiece(1, "Nocturne in E-Flat Major, Op. 9, No. 2", "Frédéric Chopin", "Arthur Rubinstein", "4:30"),
    ClassicalMusicPiece(2, "Brandenburg Concerto No. 3 in G Major, BWV 1048", "Johann Sebastian Bach", "Berlin Philharmonic", "12:30"),
    ClassicalMusicPiece(3, "Symphony No. 5 in C Minor, Op. 67", "Ludwig van Beethoven", "Vienna Philharmonic", "7:22"),
    ClassicalMusicPiece(4, "Piano Concerto No. 21 in C Major, K. 467", "Wolfgang Amadeus Mozart", "Murray Perahia", "6:47"),
    ClassicalMusicPiece(5, "The Four Seasons, 'Spring', RV 269", "Antonio Vivaldi", "Itzhak Perlman", "10:31"),
    ClassicalMusicPiece(6, "Hungarian Dance No. 5", "Johannes Brahms", "London Symphony Orchestra", "2:54"),
    ClassicalMusicPiece(7, "Prelude in C-Sharp Minor, Op. 3, No. 2", "Sergei Rachmaninoff", "Vladimir Ashkenazy", "4:12"),
    ClassicalMusicPiece(8, "Liebestraum No. 3 in A-Flat Major, S. 541", "Franz Liszt", "Lang Lang", "5:03"),
    ClassicalMusicPiece(9, "Clair de Lune, L. 32", "Claude Debussy", "Alexis Weissenberg", "5:12"),
    ClassicalMusicPiece(10, "Canon in D Major", "Johann Pachelbel", "Stuttgart Chamber Orchestra", "6:12"),
    ClassicalMusicPiece(11, "Piano Sonata No. 14 'Moonlight'", "Ludwig van Beethoven", "Wilhelm Kempff", "5:35"),
    ClassicalMusicPiece(12, "Goldberg Variations, BWV 988: Aria", "Johann Sebastian Bach", "Glenn Gould", "3:05"),
    ClassicalMusicPiece(13, "Cello Suite No. 1 in G Major, BWV 1007: Prelude", "Johann Sebastian Bach", "Yo-Yo Ma", "2:32"),
    ClassicalMusicPiece(14, "Piano Concerto No. 2 in C Minor, Op. 18", "Sergei Rachmaninoff", "Sviatoslav Richter", "9:20"),
    ClassicalMusicPiece(15, "Carmen Suite No. 1: Intermezzo", "Georges Bizet", "London Philharmonic Orchestra", "2:40"),
    ClassicalMusicPiece(16, "Symphony No. 9 'From the New World'", "Antonín Dvořák", "Berlin Philharmonic", "11:30"),
    ClassicalMusicPiece(17, "Gymnopédie No. 1", "Erik Satie", "Pascal Rogé", "3:12"),
    ClassicalMusicPiece(18, "Swan Lake, Op. 20: Scene", "Pyotr Ilyich Tchaikovsky", "Philadelphia Orchestra", "3:00"),
    ClassicalMusicPiece(19, "Requiem, K. 626: Lacrimosa", "Wolfgang Amadeus Mozart", "Vienna Philharmonic", "3:27"),
    ClassicalMusicPiece(20, "Symphony No. 7 in A Major, Op. 92: II. Allegretto", "Ludwig van Beethoven", "Berlin Philharmonic", "8:44"),
    ClassicalMusicPiece(21, "Boléro", "Maurice Ravel", "Berlin Philharmonic", "14:53"),
    ClassicalMusicPiece(22, "The Nutcracker, Op. 71: Dance of the Sugar Plum Fairy", "Pyotr Ilyich Tchaikovsky", "Royal Philharmonic Orchestra", "1:45"),
    ClassicalMusicPiece(23, "Peer Gynt Suite No. 1, Op. 46: Morning Mood", "Edvard Grieg", "Gothenburg Symphony Orchestra", "4:04"),
    ClassicalMusicPiece(24, "Pictures at an Exhibition: Promenade", "Modest Mussorgsky", "Berlin Philharmonic", "1:33"),
    ClassicalMusicPiece(25, "Messiah, HWV 56: Hallelujah Chorus", "George Frideric Handel", "London Symphony Chorus", "4:02"),
    ClassicalMusicPiece(26, "Serenade for Strings in C Major, Op. 48: Waltz", "Pyotr Ilyich Tchaikovsky", "Moscow Chamber Orchestra", "3:50"),
    ClassicalMusicPiece(27, "Piano Concerto in A Minor, Op. 16: I. Allegro molto moderato", "Edvard Grieg", "Arthur Rubinstein", "12:45"),
    ClassicalMusicPiece(28, "Rhapsody on a Theme of Paganini, Op. 43: Variation 18", "Sergei Rachmaninoff", "Philadelphia Orchestra", "2:53"),
    ClassicalMusicPiece(29, "Symphony No. 5 in C-Sharp Minor: IV. Adagietto", "Gustav Mahler", "New York Philharmonic", "10:51"),
    ClassicalMusicPiece(30, "Waltz in A Minor, B. 150", "Frédéric Chopin", "Alice Sara Ott", "2:42")
)

// Function to get the music piece by day, assuming day starts from 1 to the size of the list
fun getMusicPieceByDay(day: Int): ClassicalMusicPiece {
    return classicalMusicDatabase.getOrElse(day - 1) { classicalMusicDatabase.first() }
}
