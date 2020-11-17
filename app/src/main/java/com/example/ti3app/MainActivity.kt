package com.example.ti3app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ti3app.model.Game
import com.example.ti3app.model.Team
import com.google.firebase.firestore.FirebaseFirestore
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_games_details_dialog)

//        val jsonArr = JSONArray("[\n" +
//                "            {\n" +
//                "                'image' : 'https://liquipedia.net/commons/images/thumb/1/1f/Invictus_Gaming_logo.png/600px-Invictus_Gaming_logo.png',\n" +
//                "                'name' : 'Invictus Gaming',\n" +
//                "                'classification' : 'Invitado',\n" +
//                "                'position' : '5th-6th',\n" +
//                "                'prize_pool' : '$114,975',\n" +
//                "                'member_1' : 'Zhou',\n" +
//                "                'member_2' : 'Ferrari 430',\n" +
//                "                'member_3' : 'YYF',\n" +
//                "                'member_4' : 'ChuaN',\n" +
//                "                'member_5' : 'Faith',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'image' : 'https://liquipedia.net/commons/images/thumb/5/5a/TongFu.png/600px-TongFu.png',\n" +
//                "                'name' : 'Tonfu',\n" +
//                "                'classification' : 'Invitado',\n" +
//                "                'position' : '4th',\n" +
//                "                'prize_pool' : '$210,207',\n" +
//                "                'member_1' : 'Hao',\n" +
//                "                'member_2' : 'Mu',\n" +
//                "                'member_3' : 'KingJ',\n" +
//                "                'member_4' : 'sydm',\n" +
//                "                'member_5' : 'Banana',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'image' : 'https://liquipedia.net/commons/images/thumb/7/7e/Team_Liquid_2020.png/600px-Team_Liquid_2020.png',\n" +
//                "                'name' : 'Team Liquid',\n" +
//                "                'classification' : 'Invitado',\n" +
//                "                'position' : '7th-8th',\n" +
//                "                'prize_pool' : '$43,116',\n" +
//                "                'member_1' : 'Korok',\n" +
//                "                'member_2' : 'TC',\n" +
//                "                'member_3' : 'Bulba',\n" +
//                "                'member_4' : 'FLUFFNSTUFF',\n" +
//                "                'member_5' : 'ixmike88',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'image' : 'https://liquipedia.net/commons/images/thumb/4/43/Orange.png/600px-Orange.png',\n" +
//                "                'name' : 'Orange Esports',\n" +
//                "                'classification' : 'Invitado',\n" +
//                "                'position' : '3rd',\n" +
//                "                'prize_pool' : '$287,438',\n" +
//                "                'member_1' : 'Mushi',\n" +
//                "                'member_2' : 'kYxY',\n" +
//                "                'member_3' : 'Ohaiyo',\n" +
//                "                'member_4' : 'XtiNcT',\n" +
//                "                'member_5' : 'Net',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'image' : 'https://liquipedia.net/commons/images/thumb/2/20/Alliance2016.png/600px-Alliance2016.png',\n" +
//                "                'name' : 'Alliance',\n" +
//                "                'classification' : 'Invitado',\n" +
//                "                'position' : '1st',\n" +
//                "                'prize_pool' : '$1,437,190',\n" +
//                "                'member_1' : 'Loda',\n" +
//                "                'member_2' : 's4',\n" +
//                "                'member_3' : 'AdmiralBulldog',\n" +
//                "                'member_4' : 'EGM',\n" +
//                "                'member_5' : 'Akke',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'image' : 'https://liquipedia.net/commons/images/thumb/9/96/Fnatic_2020_infoboximage.png/600px-Fnatic_2020_infoboximage.png',\n" +
//                "                'name' : 'Fnatic',\n" +
//                "                'classification' : 'Invitado',\n" +
//                "                'position' : '7th-8th',\n" +
//                "                'prize_pool' : '$43,116',\n" +
//                "                'member_1' : 'Era',\n" +
//                "                'member_2' : 'H4nn1',\n" +
//                "                'member_3' : 'Trixi',\n" +
//                "                'member_4' : 'BigDaddy',\n" +
//                "                'member_5' : 'Fly',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'image' : 'https://liquipedia.net/commons/images/thumb/d/d6/Natus_Vincere.png/600px-Natus_Vincere.png',\n" +
//                "                'name' : 'Navi',\n" +
//                "                'classification' : 'Invitado',\n" +
//                "                'position' : '2nd',\n" +
//                "                'prize_pool' : '$632,364',\n" +
//                "                'member_1' : 'XBOCT',\n" +
//                "                'member_2' : 'Dendi',\n" +
//                "                'member_3' : 'Funn1k',\n" +
//                "                'member_4' : 'Puppey',\n" +
//                "                'member_5' : 'KuroKy',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'image' : 'https://liquipedia.net/commons/images/c/c1/Team_Zenith.png',\n" +
//                "                'name' : 'Team Zenith',\n" +
//                "                'classification' : 'Invitado',\n" +
//                "                'position' : '9th-12th',\n" +
//                "                'prize_pool' : '-',\n" +
//                "                'member_1' : 'iceiceice',\n" +
//                "                'member_2' : 'YamateH',\n" +
//                "                'member_3' : 'xy-',\n" +
//                "                'member_4' : 'xFreedom',\n" +
//                "                'member_5' : 'Ice',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'image' : 'https://liquipedia.net/commons/images/thumb/7/70/Team_Dignitas.png/600px-Team_Dignitas.png',\n" +
//                "                'name' : 'Team Dignitas',\n" +
//                "                'classification' : 'Invitado',\n" +
//                "                'position' : '9th-12th',\n" +
//                "                'prize_pool' : '-',\n" +
//                "                'member_1' : 'Aui_2000',\n" +
//                "                'member_2' : 'Sneyking',\n" +
//                "                'member_3' : 'Universe',\n" +
//                "                'member_4' : 'Waytosexy',\n" +
//                "                'member_5' : 'Fogged',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'image' : 'https://liquipedia.net/commons/images/thumb/5/5d/Virtus.pro_2019.png/600px-Virtus.pro_2019.png',\n" +
//                "                'name' : 'Virtus.pro',\n" +
//                "                'classification' : 'Invitado',\n" +
//                "                'position' : '13th-16th',\n" +
//                "                'prize_pool' : '-',\n" +
//                "                'member_1' : 'Illidan',\n" +
//                "                'member_2' : 'Crazy',\n" +
//                "                'member_3' : 'KSi',\n" +
//                "                'member_4' : 'ARS-ART',\n" +
//                "                'member_5' : 'NS',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'image' : 'https://liquipedia.net/commons/images/thumb/6/68/Dk_logo.png/600px-Dk_logo.png',\n" +
//                "                'name' : 'Team DK',\n" +
//                "                'classification' : 'Invitado',\n" +
//                "                'position' : '5th-6th',\n" +
//                "                'prize_pool' : '$114,975',\n" +
//                "                'member_1' : 'BurNIng',\n" +
//                "                'member_2' : 'Super',\n" +
//                "                'member_3' : 'rOtK',\n" +
//                "                'member_4' : 'QQQ',\n" +
//                "                'member_5' : 'MMY!',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'image' : 'https://liquipedia.net/commons/images/0/05/LGD.int_2020_logo.png',\n" +
//                "                'name' : 'LGD International',\n" +
//                "                'classification' : 'Invitado',\n" +
//                "                'position' : '9th-12th',\n" +
//                "                'prize_pool' : '-',\n" +
//                "                'member_1' : 'Pajkatt',\n" +
//                "                'member_2' : 'God',\n" +
//                "                'member_3' : 'Brax',\n" +
//                "                'member_4' : '1437',\n" +
//                "                'member_5' : 'MiSeRY',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'image' : 'https://liquipedia.net/commons/images/2/26/Mufc.png',\n" +
//                "                'name' : 'MUFC',\n" +
//                "                'classification' : 'Invitado',\n" +
//                "                'position' : '13th-16th',\n" +
//                "                'prize_pool' : '-',\n" +
//                "                'member_1' : 'dabeliuteef',\n" +
//                "                'member_2' : 'TooFuckingGood',\n" +
//                "                'member_3' : 'Ling',\n" +
//                "                'member_4' : 'FzFz',\n" +
//                "                'member_5' : 'WinteR',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'image' : 'https://liquipedia.net/commons/images/thumb/7/7a/Mouz_logo.png/600px-Mouz_logo.png',\n" +
//                "                'name' : 'Mousesports',\n" +
//                "                'classification' : 'West Qualifiers',\n" +
//                "                'position' : '13th-16th',\n" +
//                "                'prize_pool' : '-',\n" +
//                "                'member_1' : 'Black',\n" +
//                "                'member_2' : 'FATA',\n" +
//                "                'member_3' : 'qojqva',\n" +
//                "                'member_4' : 'syndereN',\n" +
//                "                'member_5' : 'paS',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'image' : 'https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/5/55/LGD_Gaminglogo_square.png/revision/latest/scale-to-width-down/220?cb=20200219215255',\n" +
//                "                'name' : 'LGD Gaming',\n" +
//                "                'classification' : 'East Qualifiers',\n" +
//                "                'position' : '9th-12th',\n" +
//                "                'prize_pool' : '-',\n" +
//                "                'member_1' : 'Sylar',\n" +
//                "                'member_2' : 'Yao',\n" +
//                "                'member_3' : 'xiao8',\n" +
//                "                'member_4' : 'DD',\n" +
//                "                'member_5' : 'ddc',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'image' : 'https://liquipedia.net/commons/images/thumb/7/72/Rattlesnake_logo.png/600px-Rattlesnake_logo.png',\n" +
//                "                'name' : 'RattleSnake',\n" +
//                "                'classification' : 'Wildcard Match',\n" +
//                "                'position' : '13th-16th',\n" +
//                "                'prize_pool' : '-',\n" +
//                "                'member_1' : 'LaNm',\n" +
//                "                'member_2' : 'Luo',\n" +
//                "                'member_3' : 'Icy',\n" +
//                "                'member_4' : 'Kabu',\n" +
//                "                'member_5' : 'Sag',\n" +
//                "            },\n" +
//                "        ]")
//
//        val jsonArr2 = JSONArray("[\n" +
//                "            {\n" +
//                "                'video' : '_cBzUPLZzBo',\n" +
//                "                'type_of_game' : 'Lower Bracket R1 (Bo1)',\n" +
//                "                'image_1' : 'hhttps://liquipedia.net/commons/images/thumb/7/70/Team_Dignitas.png/600px-Team_Dignitas.png',\n" +
//                "                'name_1' : 'Team Dignitas',\n" +
//                "                'result' : '1 - 0 ',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/thumb/7/72/Rattlesnake_logo.png/600px-Rattlesnake_logo.png',\n" +
//                "                'name_2' : 'RattleSnake',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : 'rw-lHODCljE',\n" +
//                "                'type_of_game' : 'Lower Bracket R1 (Bo1)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/0/05/LGD.int_2020_logo.png',\n" +
//                "                'name_1' : 'LGD International',\n" +
//                "                'result' : '1 - 0',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/thumb/7/7a/Mouz_logo.png/600px-Mouz_logo.png',\n" +
//                "                'name_2' : 'Mousesports',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : 'ETPh22Di5ug',\n" +
//                "                'type_of_game' : 'Lower Bracket R1 (Bo1)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/thumb/7/7e/Team_Liquid_2020.png/600px-Team_Liquid_2020.png',\n" +
//                "                'name_1' : 'Team Liquid',\n" +
//                "                'result' : '1 - 0',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/2/26/Mufc.png',\n" +
//                "                'name_2' : 'MUFC',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : 'zRlEYU7Zd78',\n" +
//                "                'type_of_game' : 'Lower Bracket R1 (Bo1)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/c/c1/Team_Zenith.png',\n" +
//                "                'name_1' : 'Team Zenith',\n" +
//                "                'result' : '1 - 0',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/thumb/5/5d/Virtus.pro_2019.png/600px-Virtus.pro_2019.png',\n" +
//                "                'name_2' : 'Virtus.pro',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : 'Npkjm3JaDOo',\n" +
//                "                'type_of_game' : 'Upper Bracket R1 (Bo3)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/thumb/d/d6/Natus_Vincere.png/600px-Natus_Vincere.png',\n" +
//                "                'name_1' : 'Navi',\n" +
//                "                'result' : '2 - 1',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/thumb/4/43/Orange.png/600px-Orange.png',\n" +
//                "                'name_2' : 'Orange Esports',\n" +
//                "            },\n" +
//                "                'video' : 'CXiGydmsAeg',\n" +
//                "                'type_of_game' : 'Upper Bracket R1 (Bo3)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/thumb/5/5a/TongFu.png/600px-TongFu.png',\n" +
//                "                'name_1' : 'TongFu',\n" +
//                "                'result' : '2 - 0',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/thumb/9/96/Fnatic_2020_infoboximage.png/600px-Fnatic_2020_infoboximage.png',\n" +
//                "                'name_2' : 'Fnatic',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : 'gyM-M-2ccng',\n" +
//                "                'type_of_game' : 'Upper Bracket R1 (Bo3)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/thumb/2/20/Alliance2016.png/600px-Alliance2016.png',\n" +
//                "                'name_1' : 'Alliance',\n" +
//                "                'result' : '2 - 0',\n" +
//                "                'image_2' : 'https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/5/55/LGD_Gaminglogo_square.png/revision/latest/scale-to-width-down/220?cb=20200219215255',\n" +
//                "                'name_2' : 'LGD Gaming',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : 'dWkjahgkayI',\n" +
//                "                'type_of_game' : 'Upper Bracket R1 (Bo3)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/thumb/6/68/Dk_logo.png/600px-Dk_logo.png',\n" +
//                "                'name_1' : 'Team DK',\n" +
//                "                'result' : '2 - 1',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/thumb/1/1f/Invictus_Gaming_logo.png/600px-Invictus_Gaming_logo.png',\n" +
//                "                'name_2' : 'Invictus Gaming',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : 'zXEXRIRVQNM',\n" +
//                "                'type_of_game' : 'Lower Bracket R2 (Bo1)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/thumb/4/43/Orange.png/600px-Orange.png',\n" +
//                "                'name_1' : 'Orange Esports',\n" +
//                "                'result' : '1 - 0',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/thumb/7/70/Team_Dignitas.png/600px-Team_Dignitas.png',\n" +
//                "                'name_2' : 'Team Dignitas',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : 'JBR3skEqm_U',\n" +
//                "                'type_of_game' : 'Lower Bracket R2 (Bo1)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/thumb/9/96/Fnatic_2020_infoboximage.png/600px-Fnatic_2020_infoboximage.png',\n" +
//                "                'name_1' : 'Fnatic',\n" +
//                "                'result' : '1 - 0',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/0/05/LGD.int_2020_logo.png',\n" +
//                "                'name_2' : 'LGD International',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : '1mO_Ntz2t9c',\n" +
//                "                'type_of_game' : 'Lower Bracket R2 (Bo1)',\n" +
//                "                'image_1' : 'https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/5/55/LGD_Gaminglogo_square.png/revision/latest/scale-to-width-down/220?cb=20200219215255',\n" +
//                "                'name_1' : 'LGD Gaming',\n" +
//                "                'result' : '0 - 1',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/thumb/7/7e/Team_Liquid_2020.png/600px-Team_Liquid_2020.png',\n" +
//                "                'name_2' : 'Team Liquid',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : '8ElxSkTpoaY',\n" +
//                "                'type_of_game' : 'Lower Bracket R2 (Bo1)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/thumb/1/1f/Invictus_Gaming_logo.png/600px-Invictus_Gaming_logo.png',\n" +
//                "                'name_1' : 'Invictus Gaming',\n" +
//                "                'result' : '1 - 0',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/c/c1/Team_Zenith.png',\n" +
//                "                'name_2' : 'Team Zenith',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : 'LVlTIuCz1Kc',\n" +
//                "                'type_of_game' : 'Lower Bracket R3 (Bo1)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/thumb/4/43/Orange.png/600px-Orange.png',\n" +
//                "                'name_1' : 'Orange Esports',\n" +
//                "                'result' : '1 - 0',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/thumb/9/96/Fnatic_2020_infoboximage.png/600px-Fnatic_2020_infoboximage.png',\n" +
//                "                'name_2' : 'Fnatic',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : 'w67lt3SOSpU',\n" +
//                "                'type_of_game' : 'Lower Bracket R3 (Bo1)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/thumb/4/43/Orange.png/600px-Orange.png',\n" +
//                "                'name_1' : 'Team Liquid',\n" +
//                "                'result' : '0 - 1',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/thumb/1/1f/Invictus_Gaming_logo.png/600px-Invictus_Gaming_logo.png',\n" +
//                "                'name_2' : 'Invictus Gaming',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : 'b1XxJOFXnno',\n" +
//                "                'type_of_game' : 'Upper Bracket R2 (Bo3)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/thumb/d/d6/Natus_Vincere.png/600px-Natus_Vincere.png',\n" +
//                "                'name_1' : 'Navi',\n" +
//                "                'result' : '2 - 1',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/thumb/5/5a/TongFu.png/600px-TongFu.png',\n" +
//                "                'name_2' : 'TongFu',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : '4EDICmf7oQs',\n" +
//                "                'type_of_game' : 'Upper Bracket R2 (Bo3)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/thumb/2/20/Alliance2016.png/600px-Alliance2016.png',\n" +
//                "                'name_1' : 'Alliance',\n" +
//                "                'result' : '2 - 1',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/thumb/6/68/Dk_logo.png/600px-Dk_logo.png',\n" +
//                "                'name_2' : 'Team DK',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : 'q-An7Cbyn8E',\n" +
//                "                'type_of_game' : 'Lower Bracket R4 (Bo3)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/thumb/6/68/Dk_logo.png/600px-Dk_logo.png',\n" +
//                "                'name_1' : 'Team DK',\n" +
//                "                'result' : '1 - 2',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/thumb/4/43/Orange.png/600px-Orange.png',\n" +
//                "                'name_2' : 'Orange Esports',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : 'FRXhrGrbEwA',\n" +
//                "                'type_of_game' : 'Lower Bracket R4 (Bo3)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/thumb/5/5a/TongFu.png/600px-TongFu.png',\n" +
//                "                'name_1' : 'TongFu',\n" +
//                "                'result' : '2 - 1',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/thumb/1/1f/Invictus_Gaming_logo.png/600px-Invictus_Gaming_logo.png',\n" +
//                "                'name_2' : 'Invictus Gaming',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : '-ApNQY3xrTQ',\n" +
//                "                'type_of_game' : 'Lower Bracket R5 (Bo3)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/thumb/4/43/Orange.png/600px-Orange.png',\n" +
//                "                'name_1' : 'Orange Esports',\n" +
//                "                'result' : '2 - 1',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/thumb/5/5a/TongFu.png/600px-TongFu.png',\n" +
//                "                'name_2' : 'TongFu',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : 'qbJiyMtpohU',\n" +
//                "                'type_of_game' : 'Upper Bracket Final (Bo3)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/thumb/d/d6/Natus_Vincere.png/600px-Natus_Vincere.png',\n" +
//                "                'name_1' : 'Navi',\n" +
//                "                'result' : '0 - 2',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/thumb/2/20/Alliance2016.png/600px-Alliance2016.png',\n" +
//                "                'name_2' : 'Alliance',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : 'kybl33z2Rr4',\n" +
//                "                'type_of_game' : 'Lower Bracket Final (Bo3)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/thumb/d/d6/Natus_Vincere.png/600px-Natus_Vincere.png',\n" +
//                "                'name_1' : 'Navi',\n" +
//                "                'result' : '2 - 1',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/thumb/4/43/Orange.png/600px-Orange.png',\n" +
//                "                'name_2' : 'Orange Esports',\n" +
//                "            },\n" +
//                "            {\n" +
//                "                'video' : 'IfOugI2ccUU',\n" +
//                "                'type_of_game' : 'Grand Final (Bo5)',\n" +
//                "                'image_1' : 'https://liquipedia.net/commons/images/thumb/2/20/Alliance2016.png/600px-Alliance2016.png',\n" +
//                "                'name_1' : 'Alliance',\n" +
//                "                'result' : '3 - 2',\n" +
//                "                'image_2' : 'https://liquipedia.net/commons/images/thumb/d/d6/Natus_Vincere.png/600px-Natus_Vincere.png',\n" +
//                "                'name_2' : 'Navi',\n" +
//                "            },\n" +
//                "        ]")
//
//        val firebaseFirestore = FirebaseFirestore.getInstance()
//
//        for (i in 0 until jsonArr.length()) {
//            val aux = jsonArr.get(i) as JSONObject
//            var team = Team()
//            team.image = aux.getString("image")
//            team.name = aux.getString("name")
//            team.classification = aux.getString("classification")
//            team.position = aux.getString("position")
//            team.prizepool = aux.getString("prize_pool")
//            team.member1 = aux.getString("member_1")
//            team.member2 = aux.getString("member_2")
//            team.member3 = aux.getString("member_3")
//            team.member4 = aux.getString("member_4")
//            team.member5 = aux.getString("member_5")
//            firebaseFirestore.collection("team").document().set(team)
//        }
//
//        for (i in 0 until jsonArr2.length()) {
//            val aux = jsonArr2.get(i) as JSONObject
//            var game = Game()
//            game.video = aux.getString("video")
//            game.type_of_game = aux.getString("type_of_game")
//            game.image_1 = aux.getString("image_1")
//            game.name_1 = aux.getString("name_1")
//            game.result = aux.getString("result")
//            game.image_2 = aux.getString("image_2")
//            game.name_2 = aux.getString("name_2")
//            firebaseFirestore.collection("game").document().set(game)
//        }
    }
}