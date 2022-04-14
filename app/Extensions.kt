package com.hudazamov.myquran.activity

import android.content.Context
import android.media.MediaPlayer
import android.widget.Toast
import com.hudazamov.myquran.R
import com.hudazamov.myquran.model.LettersData


fun getLettersData(context: Context): ArrayList<LettersData> {

    val arrayList = ArrayList<LettersData>()
    arrayList.add(LettersData("", "Alifbo", "ا   ب   ت   ث   ج  ح   خ   د   ذ   ر  ز   س   ش   ص  ض   ط   ظ  ع  غ   ف   ق   ك   ل   م   ن    و   ه  ي",
        R.raw.alifbo, "Arab alifbosida 28 ta harf mavjud. Arab alifbosi bizning harflarimizdan o'ngdan chapga qarab yozilishi va o'qilishi, bosh hamda kichik harflari yo'qligi har bir harf alohida,so'z boshida, o'rtasida va oxirida keladigan shakllarga ega ekanligi jihatidan farq qiladi. ",
        R.raw.a_unli
    ))

    //Alif
    arrayList.add(LettersData("ا", "Alif harfi", "اَ     اِ     اُ",
        R.raw.harakat, "Arab alifbosining hammasi undosh harflardir. Ulardan keyin keladigan unli tovush (qisqa unli) larni belgilar (harakatlar) ifodalaydi." + "\nUnli tovushlar uchta:\n1. َ_ fatha - a;\n2. _ِ   kasra -i;\n3. ُ-  zamma - u.\nUnli tovushlarni ifoda etuvchi belgilar harakat deyiladi. Harakatlar o'zbek tilidagi 'a', 'i', 'u' unlilari kabi talaffuz qilinadi. Alif harfi shu harakatlar bilan 'a', 'i', 'u' tovushlarini ifodalaydi. ",
        R.raw.a_unli
    ))

    //Ro
    arrayList.add(LettersData("ر", "RO harfi", "رَ   رِ   رُ\n" + "اَرْ   اِرْ   اُرْ",
        R.raw.ro, "Ro harfining talaffuzi o'zbek tilidagi r tovushi kabidir. Bu undosh kasra bilan kelganda ingichkaroq qilib o'qiladi, bu tarqiq deyiladi. Fatha yoki zamma bilan kelganda esa yo'g'onroq qilib talaffuz qilinadi, bu tafhim deb ataladi. Ro harfi fathali bo'lib kelganda ro deb o'qiladi",
        R.raw.ro_1
    ))

    //Za
    arrayList.add(LettersData("ز", "ZA harfi", "زَ   زِ   زُ \n اَزْ  اِزْ   اُزْ   زَرْ   زِرْ  زُرْ  اَزْرُ  اِزْرُ   اُزْرُ  اُرْزُ",
        R.raw.za, "Za harfi talaffuzi o'zbek tilidagi z tovushi singaridir.",
        R.raw.za_1
    ))

//Mim
    arrayList.add(LettersData("م", "MIM harfi", "مَـ      مِـ      مُ \nاَمْ  اِمْ  اُمْ  مُرْ   مُزْ  رُمْ  اَمَرَ  اُمِرَ  اَمْرُ   اِمْرُ  رَمْزُ  اِرْمِ   مَرْمَرْ    رَمْرَمْ   زَمْزَمْ   اَرْزَمْ ",
        R.raw.ma, "Mim hafri talaffuzi o'zbek tilidagi m tovushi singaridir.",
        R.raw.ma_2
    ))

//Ta
    arrayList.add(LettersData("ت", "TA harfi", " تَـ   تِـ  تُ \n  مَتْ  مِتْ  مُتْ  تَمَرْ   تَرِرْ  زُرْتَ  اَمَرْتِ   مَرَرْتُ  اُمِرْتُ  اَمَرَتْ   اَمَرْتُمْ  اُمِرْتُمْ  مَرَرْتُمْ   مُرِرْتُمْ  ",
        R.raw.ta, "Ta harfi talaffuzi o'zbek tilidagi t tovushi kabidir.",
        R.raw.ta_1
    ))


//Na
    arrayList.add(LettersData("ن", "NA harfi", "نـَ    نِـ   نُ \n اَنْ  اِنْ  زِنْ  مَنْ   مِنْ   نَمْ  اَنْتَ  نِمْتَ   اَنْتُمْ  نِمْتُمْ  نَزِرُ   نَزِنُ  اَمَرْنَ  اُمِرْنَ   مَرَرْنَ   مُرِرْنَ  اَمْرَرْنَ",
        R.raw.na, "Na harfi talaffuzi o'zbek tilidagi n tovushi kabidir.",
        R.raw.na_1
    ))


//Ya
    arrayList.add(LettersData("ي", "YA harfi", "يـَ   يـِ  يُ\n  اَيْ  اَيْمُ  زَيْتُ  مَيْتُ   رَاْيُ  رَمْيُ  يَمَنْ   مَرْيَمْ  مَيْزَرْ  مَيْمَنْ   اَيْمَنْ  اَمْرَيْنِ  زَيْتَيْنِ   اَيْمَيْنِ  مَيْتَيْنِ",
        R.raw.ya, "Ya harfi talaffuzi o'zbek tilidagi y tovushi kabidir.",
        R.raw.ya_1
    ))


//Ba
    arrayList.add(LettersData("ب", "BA harfi", "بـَ   بـِ   بُ\n  اَبْ  اِبْنُ   بِنْتُ  بَيْتُ   بَيْنُ  رَيْبُ  ذَيْنَبْ   بَرْبَرْ  بَيْرَمْ  اَبْرَمْ   مِنْبَرْ  بِاَمْرَيْنِ  بِبَيْتَيْنِ   مِنْبَرَيْنِ  زَيْنَبَْيْنِ   ",
        R.raw.ba, "Ba harfi talaffuzi o'zbek tilidagi b tovushi kabidir.",
        R.raw.ba_1
    ))


//Kaf
    arrayList.add(LettersData("ك", "KAF harfi", "كَـ  كِـ  ـکُ ( ك - ڪـ)\n  كَمْ  كُمْ  كُنْ  كَيْ   بَكْرُ   مَكْرُ  كَرْمُ  كَنْزُ   تَرْكُ  كَتَبَ  يَكْتُبُ   تَرَكَ  يَتْرُكُ  كَتَبْتُمْ   اَمَرَكَ  اَمَرَتْكَ  كُنْتُ  مُمْكِنْ   ",
        R.raw.ka, "Kaf hafri talaffuzi o'zbek tilidagi k tovushi kabidir.",
        R.raw.ka_1
    ))


//Lam
    arrayList.add(LettersData("ل", "LAM harfi", "لَـ      لِـ    لُ \n اَلْ  نَلْ  لَمْ  لُمْ   لَنْ  كِلْ  نَزَلَ   لَزِمَ  كَمُلَ  اَنْزَلَ   اَلْزَمَ  اَكْمَلَ  اَكَلَتْ   اَكَلْنَ  اَكَلْتَ  اَكَلْتِ   اَكَلْتُ اَكَلْتُمْ  بُلْبُلْ   يَلَمْلَمْ  تَزَلْزَلَ   يَتَزَلْزَلُ  مُتَزَلْزِلْ  ",
        R.raw.la, "Lam hafri talaffuzi o'zbek tilidagi l tovushi kabidir.",
        R.raw.la_1
    ))


//Vav
    arrayList.add(LettersData("و", "VAV harfi", "وَ      وِ      وُ \n اَوْ  رَوْ  نَوْ  لَوْ  وَرَمْ   وَتَرْ  وَمَنْ  وَلَنْ  وَلَمْ   وَكَمْ  اَوْلُ  رَوْبُ  يَوْبُ   كَوْنُ  وَيْلُ  وَزْنُ   كَوْكَبْ  مَوْكِبْ  اَوْلَمْتُمْ  اَوْتَرْتُمْ",
        R.raw.va, "Vav hafri talaffuzi o'zbek tilidagi v tovushi kabidir.",
        R.raw.va_1
    ))


//Ha
    arrayList.add(LettersData("ﻩ", "HA harfi", "ﻫـَ  ـﻬـِ  ـﻪُ  (ﻩ)\n هَبْ  هَمْ  هَلْ  هُوَ   هِيَ  هُمْ  زُهْ  اَهَمْ   وَهَبْ  لَهَبْ  وَهَمْ    لَهُمْ  بِهِمْ  مِنْهُ  مِنهُمْ  اِلَيْهِ  اِلَيْهِمْ   اَمْهِلْهُمْ  ",
        R.raw.ha, "Ha hafri talaffuzi o'zbek tilidagi yumshoq h tovushi kabidir.",
        R.raw.ha_1
    ))


//Fa
    arrayList.add(LettersData("ف", "FA harfi", "فَـ      ـفِـ     فُ \n فَمْ  فَنْ  كَفْ  فَلَكْ  كَفَنْ  نَفَرْ  فَوْرُ   فَوْزُ   فَهْمُ  فِكْرُ   زِفْرُ  كِفْلُ  فُلْفُلْ  نَوْفَرْ  نَوْفَلْ  فَهِمَ  يَفْهَمُ  اِفْهَمْ  اِفْتَتَنَ  يَفْتَتِنُ  اِفْتَكَرَ  يَفْتَكِرُ ",
        R.raw.fa, "Fa hafri talaffuzi o'zbek tilidagi f tovushi kabidir.",
        R.raw.fa_1
    ))


//Qof
    arrayList.add(LettersData("ق", "QOF harfi", "قَـ     ـقـِ      قُ \n  زُقْ   قِنْ   قُلْ   قُمْ   قِفْ   قِهْ   قَلْبُ   قَبْلُ   فَوْقُ   قَلَمْ   قَمَرْ  لَقَبْ   قُمْقُمْ   اِقْتَرَبَ   يَقْتَرِبُ  اِنْقَلَبَ  يَنْقَلِبُ  \n كَمَرْـ قَمَرْ  \n فَلَكْ ـ فَلَقْ  \n فَرْكُ ـ فَرْفُ ",
        R.raw.qo, "Qof hafri talaffuzi o'zbek tilidagi q tovushi kabidir.Qof harfi fathali bo'lib kelganda 'qo' deb o'qiladi.",
        R.raw.qo_1
    ))


//Shin
    arrayList.add(LettersData("ش", "SHIN harfi", "شَـ      شِـ     شُ  \n رَشْ  بُشْ   شَرْ  شَقْ  شَمْ  شَكْ  بِشْرُ  شِرْبُ   شَهْرُ  بَشْرُ  شُكْرُ   شُرْبُ   مَشْرَبْ   مَشْرِبْ   مَشرِقْ  مُشتَهِرْ  مُشْتَرَكْ   اِشْتَهَرَ  يَشْتَهِرُ  اِبْرَنْشَقْ  يَبْرَنْشِقُ  ",
        R.raw.sha, "Shin hafri talaffuzi o'zbek tilidagi sh tovushi kabidir.",
        R.raw.sha_1
    ))


//sin
    arrayList.add(LettersData("س", "SIN harfi", "   سَـ   ـسـِ   سُ \n بَسْ  سَمْ   سِرْ  سِنْ  سِلْ  سَفَرْ  سَقَرْ  سَبَقْ  سَلَفْ  سَمَكْ  فَرَسْ  مَسْلَكْ  مَسْكَنْ  مُسْلِمْ    مُسْرِفْ  سِمْسِمْ  اَسْلَمَ  يُسْلِمُ  اِسْتَيْسَرَ  يَسْتَيْسِرُ ",
        R.raw.sa, "Sin hafri talaffuzi o'zbek tilidagi s tovushi kabidir.",
        R.raw.sa_1
    ))


//Sfa
    arrayList.add(LettersData("ث", "SA harfi", "ثـَ   ـثـِ   ـثُ \n بَثْ  ثِبْ  ثَمْ  ثِنْ  ثَمَرْ  ثَمَنْ  ثَوْرُ  ثَوْبُ   ثَيْبُ  مِثْلُ  مُثْلُ  مَثَلْ  كَوْثَرْ  اَكْثَرَ  يُكْثِرُ  اَثْبَتَ  يُثْبِتُ  اِسْتَكثَرَ  يَسْتَكْثِرُ  اِسْتَثْقَلَ   يَسْتَثْقِلُ  سَمَرْ   ثَمَرْ  سَبْتُ    ثَبْتُ   سَلْسُ    ثَلْثُ",
        R.raw.sa18, "O'zbek tilida bunga o'xshash tovush yo'q. Bu tovush til uchi oldingi tishlar qirrasiga tegishi bilan talaffuz etiladi.",
        R.raw.sa18_1
    ))


//sod
    arrayList.add(LettersData("ص", "SOD harfi", "صـَ   ـصـِ   ـصُ \n صُمْ   صِفْ   فَصْ   صَرَفْ   صَبَرْ  بَصَرْ  قَصَبْ  بَصَرَ  يَنْصُرُ  اِسْتَبْصَرَ  يَسْتَبْصِرُ \n سَفَرْـ صَفَرْ \n سَيْفُ ـ  صَيْفُ  \n اِنْتَسَبَ ـ اِنْتَصَبَ ",
        R.raw.so, "O'zbek tilida bunga o'xshash tovush yo'q. Sod fathali bo'lib kelganda, 'so' deb o'qiladi. Sod tovushi tilning uchi ikki pastki old tishning yuqori qismiga tegishi bilan talaffuz etiladi.",
        R.raw.so_1
    ))


//to
    arrayList.add(LettersData("ط", "TO harfi", "ﻃَ   ـﻄِ   ـﻂُ  \n طَلْ  طَيْ  شَطْ  بَطْ  قَطْ  فَقَطْ  وَطَنْ  طَلَبْ  طَرَفْ  طُهْرُ  طِفْلُ  مَطَرْ  مَطْلَبْ  مَسْقَطْ  مَوْطِنْ  مَرْبِطْ   اِصْطَبَرَ  يَصْطَبِرُ  اِسْتَوْطَنَ  يَسْتَوْطِنُ    تَرَفْ ـ طَرَفْ \n  سَبْتُ ـ سَبْطُ  \n مُسْتَتِرَ ـ مُسْتَطِرْ  ",
        R.raw.to, "O'zbek tilida bunga o'xshash tovush yo'q. To fathali bo'lib kelganda, 'to' deb yog'on o'qiladi. To tovushi tilning uchi ustki old tishlarning tubiga tegishi va tilning tanglayga ko'tarilishi bilan talaffuz qilinadi. To harfi Itqi deb ham ataladi.",
        R.raw.to_1
    ))


//jim
    arrayList.add(LettersData("ج", "JIM harfi", "خـَ   ـخـِ   ـجُ \n  جَمْ  خَرْ  جِنْ  جَبْ  جُلْ  جَبَلْ  جَمَلْ  اَجْرُ  فَجْرُ  جَوْهَرْ  جَوْرَبْ  تَجَوْرَبَ  يَتَجَوْرَبُ  اِسْتَجْلَبَ   يَسْتَجْلِبُ  ",
        R.raw.ja, "Jim harfining talaffuzi o'zbek tilidagi j tovushi kabidir.",
        R.raw.ja_1
    ))


//xo
    arrayList.add(LettersData("خ", "XO harfi", "خـَ    ـخـِ   ـخُ \n خَبْ  خَلْ  خَرَجْ  خَبَرْ  خَشَبْ  خَلَفْ  خَيْرُ  خَتْمُ  خَمْرُ  خَوْفُ  مَخْرَجْ  مُخْبِرْ  اَخْرَجَ  يُخْرِجُ   اَخْبَرَ  يُخْبِرُ  اِسْتَخْبَرَ  يَسْتَخْبِرُ  اِسْتَخْرَجَ  يَسْتَخْرِجُ ",
        R.raw.xo, "Xo harfining talaffuzi o'zbek tilidagi x  tovushi kabidir. Xo fathali bo'lib kelganda 'xo' deb yo'g'on o'qiladi.",
        R.raw.xo_1
    ))

//ha
    arrayList.add(LettersData("ح", "XA harfi", "حـَ   ـحـِ   ـحُ \n  حَيْ  حِلْ  حَجْ  حَسَنْ  حَسَبْ  حَسَفْ  مُحْسِنْ  مَحْشَرْ  مِنْحَرْ  مَحْفَلْ  اَحْسَنُ  اِمْتَحَنَ  يَمْتَحِنُ  اِحْتَمَلَ  يَحْتَمِلُ  اِسْتَحْسَنَ  يَسْتَحْسِنُ  اِحْرَنْجَمَ   يَحرَنْجِمُ\n  خَلْقُ ـ حَلْقُ \n  خَتْمُ ـ حَتْمُ  \n اَرْخَمْ ـ اَرْحَمْ  ",
        R.raw.ha23, "O'zbek tilida bunga o'xshash tovush yo'q. Xa harfi xalqum o'rtasidan talaffuz etiladi.",
        R.raw.ha23_1
    ))

//g'oyn
    arrayList.add(LettersData("غ", "G'OYN  harfi", "غـَ   ـغـِ   ـغُ \n  غَمْ   غَبْ   غِلْ   غَيْرُ  بَغْلُ  فَرْغُ   غَبْغَبْ  مَبْلَغْ  مَغْرِبْ  اِغْلِبْ  اِغْفِرْ  اِشْتَغَلَ  يَشْتَغِلُ  اِسْتَغْفَرَ  يَسْتَغْفِرُ ",
        R.raw.go24, "G'oyn harfining talaffuzi o'zbek tilidagi g' tovushi kabidir. G'oyn fathali bo'lib kelganda g'o deb yo'g'on talaffuz etiladi.",
        R.raw.go24_1
    ))

//ayn
    arrayList.add(LettersData("ع", "AYN harfi", "عـَ   ـعـِ   ـعُ  \n  بِعْ   عَنْ   عَمْ   سَعْ  مَعَ   عَرَبْ   عَجَمْ  عَجَبْ   عَمَلْ  عِلْمُ   عُمْرُ  جَمْعُ  جَعْلُ  عَبْعَبْ   عَسْكَرْ  عَيْلَمْ   جَعْفَرْ  عَنْبَرْ \n غَيْنُ ـ عَيْنُ  \n بَغْلُ ـ بَعْلُ \n بَلْغُ ـ بَلْعُ   ",
        R.raw.ayn, "O'zbek tilida bunga o'xshash tovush yo'q. Ayn harfi halqum o'rtasidan talaffuz etiladi.",
        R.raw.ayn_1
    ))

//dal
    arrayList.add(LettersData("د", "DAL harfi", "دَ   ـدِ   ـدُ \n  دُمْ   دُبْ   دُفْ   رِدْ  زِدْ  تَدْ  دَرْسُ  دَفْعُ   دَبْغُ   دَلْكُ   دَهْرُ   دُهْنُ   دُلْدُلْ  فُدْفُدْ  هُدْهُدْ  اُشْدُدْ  اِعْتَدَلَ   يَعْتَدِلُ  اِسْتَرْشَدَ  يَسْتَرْشِرُ  ",
        R.raw.da, "Dal harfining talaffuzi o'zbek tilidagi d tovushi kabi talaffuz etiladi.",
        R.raw.da_1
    ))

//zod
    arrayList.add(LettersData("ض", "ZOD harfi", "ضـَ   ـضـِ   ـضُ  \n ضَيْفُ   عَضْلُ   ضَهْبُ  ضَبْطُ   ضَعْفُ  عَرْضُ  مَضْرِبْ   مِضْرَبْ   اِضْرِبْ   يَضْرِبُ   اَضْرِبُ   نَضْرِبُ   اِضْطَرَبَ  يَضْطَرِبُ  اسْتَضْعَفَ   يَسْتَضْعِفُ  \n دَرْسُ ـ ضَرْسُ  \n وَدْعُ ـ وَضْعُ \n بَعْدُ ـ بَعْضُ",
        R.raw.zo, "O'zbek tilida bunga o'xshash tovush yo'q.Zod fathali bo'lib kelganda 'zo' deb yo'g'on o'qiladi." ,
        R.raw.zod29_1
    ))

//zal
    arrayList.add(LettersData("ذ", "ZAL harfi", "ذَ   ـذِ   ـذُ \n  اِذْ   مُذْ   خُذْ   عُذْ   ذُبْ   ذَقْ   ذَرْ  مُنْذُ  اِذْنُ  بَذْلُ   ذِكْرُ  ذِهْنُ  ذَهَبْ   مَذْهَبْ  ذَهَلَ  يَذْهَلُ  بَذَلَ  يَبْذُلُ  اَذْهَبَ  يَذْهِبُ  \n ذِفْرُ ـ زِفْرُ \n  بَذْلُ ـ  بَزْلُ \n اَبْذَلْ ـ اَبْزَلْ  ",
        R.raw.za28, "O'zbek tilida bunga o'xshash tovush yo'q.",
        R.raw.za28_1
    ))

//zo
    arrayList.add(LettersData("ظ", "ZO harfi", "ظَ   ـظِ   ـظُ  \n ظَنْ   ظِلْ  فَظْ   حَظْ   عَظْ   لَظْ   ظَفَرْ  حَظَرْ  ظَمَرْ  ظَلَفْ   عِظَمْ   بَظْمُ   ظَلْفُ  ظِلْفُ  حِظْلُ   ظُلْمُ  ظُهْرُ  اَظْهَرْ  اَظْفَرْ  مَظْهَرْ  مَنْظَرْ  مُظْهِرْ  مُظْلِمْ   ظَهَرَ  يَظْهَرُ  بَظَرَ  يَبْظُرُ  ظَلَمَ   يَظْلَمُ  اِنْتَظَمَ  يَبْتَظِمُ   اِسْتَعْظَمَ   يَسْتَعْظِمُ  \n ذَفْرْ ـ ظَفرْ \n حَظْرْ ـ حَضَرْ \n  ظَهْرُ ـ ضَهْرُ \n زَهَرْ ـ ظَهَرْ  \n اَزْهَرْ ـ اَظْهَرْ \n اعْزَمْ ـ اَعْظَمْ ",
        R.raw.zo29, "O'zbek tilida bunga o'xshash tovush yo'q.\n Shunga qadar yozilgan arabcha so'zlar (cho'ziq unli) siz edi. Endi arabiy kalimlarning madli ko'rinishlarini ham keltirib o'tamiz. Keyingi bosqichda siz Qur'on o'qishlik uchun tajvid va uning qoidalari bilan tanishasiz.",
        R.raw.zo29_1
    ))

    return arrayList

}





// Extension property to get media player duration in seconds
val MediaPlayer.seconds:Int
    get() {
        return this.duration / 1000
    }


// Extension property to get media player current position in seconds
val MediaPlayer.currentSeconds:Int
    get() {
        return this.currentPosition/1000
    }


// Extension function to show toast message quickly
fun Context.toast(message:String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}


