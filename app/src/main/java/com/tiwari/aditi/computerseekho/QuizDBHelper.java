package com.tiwari.aditi.computerseekho;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tiwari.aditi.computerseekho.QuizContract.*;

import java.util.ArrayList;
import java.util.List;

public class QuizDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ComputerSeekho.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable(){

        String qstring1 = "def fact(x):\n" +
                "    if x == 0:\n" +
                "        return 1\n" +
                "    return x * fact(x - 1)\n" +
                "\n" +
                "x=int(5)\n" +
                "print fact(x)\n";
        Question q1 = new Question(qstring1,
                "120",
                "1",
                "24", 1);
        addQuestion(q1);

        String qstring2 = "l=[]\n" +
                "for i in range(20, 50):\n" +
                "    if (i%7!=0) and (i%5==0):\n" +
                "        l.append(str(i))\n" +
                "\n" +
                "print ','.join(l)";
        Question q2 = new Question(qstring2,
                "20,21,25,28,30,35,40,42,45,49",
                "20,25,30,40,45,50",
                "20,25,30,40,45",
                3);
        addQuestion(q2);

        String qstring3 = "n=int(4)\n" +
                "d=dict()\n" +
                "for i in range(1,n+1):\n" +
                "    d[i]=i*i\n" +
                "\n" +
                "print d";
        Question q3 = new Question(qstring3,
                "{1: 1, 2: 2, 3: 3, 4: 4}",
                "{1: 1, 2: 4, 3: 9, 4: 16}",
                "[1,4,9,16]",
                2);
        addQuestion(q3);

        String qstring4 = "values=raw_input()\n" +
                "l=values.split(\",\")\n" +
                "t=tuple(l)\n" +
                "print t";
        Question q4 = new Question(qstring4,
                "Accept comma separated input by user and print it",
                "Accept comma separated input by user and print it as a list",
                "Accept comma separated input by user and print it as a tuple",
                3);
        addQuestion(q4);

        String qstring5 = "class InputOutString(object):\n" +
                "    def __init__(self):\n" +
                "        self.s = \"\"\n" +
                "\n" +
                "    def getString(self):\n" +
                "        self.s = raw_input()\n" +
                "\n" +
                "    def printString(self):\n" +
                "        print self.s.upper()\n" +
                "\n" +
                "strObj = InputOutString()\n" +
                "strObj.getString()\n" +
                "strObj.printString()\n";
        Question q5 = new Question(qstring5,
                "Accepts input by user and print it",
                "Accept input by user and print it as a list",
                "Accept input by user and print it in uppercase",
                3);
        addQuestion(q5);

        String qstring6 = "def square(num):\n" +
                "    return num ** 2\n" +
                "\n" +
                "print square(2)";
        Question q6 = new Question(qstring6,
                "2",
                "4",
                "8",
                2);
        addQuestion(q6);

        String qstring7 = "class Person:\n" +
                "    # Define the class parameter \"name\"\n" +
                "    name = \"Person\"\n" +
                "    \n" +
                "    def __init__(self, name = None):\n" +
                "        # self.name is the instance parameter\n" +
                "        self.name = name\n" +
                "\n" +
                "jeffrey = Person(\"Jeffrey\")\n" +
                "print \"%s name is %s\" % (Person.name, jeffrey.name)";
        Question q7 = new Question(qstring7,
                "Person name is Jeffery",
                "Jefferey name is Jeffery",
                "name name is Jeffery",
                1);
        addQuestion(q7);

        String qstring8 = "def SumFunction(number1, number2):\n" +
                "\treturn number1+number2\n" +
                "\n" +
                "print SumFunction(1,2)";
        Question q8 = new Question(qstring8,
                "1",
                "2",
                "3",
                3);
        addQuestion(q8);

        String qstring9 = "def printValue(n):\n" +
                "\tprint str(n)\n" +
                "\n" +
                "printValue(3)";
        Question q9 = new Question(qstring9,
                "3",
                "\"3\"",
                "Three",
                2);
        addQuestion(q9);

        String qstring10 = "def printValue(s1,s2):\n" +
                "\tprint int(s1)+int(s2)\n" +
                "\n" +
                "printValue(\"3\",\"4\")";
        Question q10 = new Question(qstring10,
                "7",
                "34",
                "Error",
                1);
        addQuestion(q10);

        String qstring11 = "def printValue(s1,s2):\n" +
                "\tprint s1+s2\n" +
                "\n" +
                "printValue(\"3\",\"4\")";
        Question q11 = new Question(qstring11,
                "3+4",
                "34",
                "7",
                2);
        addQuestion(q11);

        String qstring12 = "def printValue(s1,s2):\n" +
                "\tlen1 = len(s1)\n" +
                "\tlen2 = len(s2)\n" +
                "\tif len1>len2:\n" +
                "\t\tprint s1\n" +
                "\telif len2>len1:\n" +
                "\t\tprint s2\n" +
                "\telse:\n" +
                "\t\tprint s1\n" +
                "\t\tprint s2\n" +
                "\t\t\n" +
                "\n" +
                "printValue(\"one\",\"three\")\n";
        Question q12 = new Question(qstring12,
                "one",
                "5",
                "three",
                3);
        addQuestion(q12);


        String qstring13 = "def checkValue(n):\n" +
                "\tif n%2 == 0:\n" +
                "\t\tprint \"It is an even number\"\n" +
                "\telse:\n" +
                "\t\tprint \"It is an odd number\"\n" +
                "\t\t\n" +
                "\n" +
                "checkValue(7)";
        Question q13 = new Question(qstring13,
                "It is an even number",
                "It is an odd number",
                "7",
                2);
        addQuestion(q13);

        String qstring14 = "def printDict():\n" +
                "\td=dict()\n" +
                "\td[1]=1\n" +
                "\td[2]=2**2\n" +
                "\td[3]=3**2\n" +
                "\tprint d\n" +
                "\t\t\n" +
                "\n" +
                "printDict()";
        Question q14 = new Question(qstring14,
                "d",
                "[1, 4, 9]",
                "{1:1, 2:4, 3:9}",
                3);
        addQuestion(q14);


        String qstring15 = "def printDict():\n" +
                "\td=dict()\n" +
                "\tfor i in range(1,4):\n" +
                "\t\td[i]=i**2\n" +
                "\tfor (k,v) in d.items():\t\n" +
                "\t\tprint v\n" +
                "\t\t\n" +
                "\n" +
                "printDict()";
        Question q15 = new Question(qstring15,
                "1 \n 2 \n 3",
                "1 \n 4 \n 9",
                "{1:1, 2:4, 3:9}",
                2);
        addQuestion(q15);

        String qstring16 = "def printDict():\n" +
                "\td=dict()\n" +
                "\tfor i in range(1,4):\n" +
                "\t\td[i]=i**2\n" +
                "\tfor k in d.keys():\t\n" +
                "\t\tprint k\n" +
                "\t\t\n" +
                "\n" +
                "printDict()";
        Question q16 = new Question(qstring16,
                "1 \n 2 \n 3",
                "1 \n 4 \n 9",
                "{1:1, 2:4, 3:9}",
                1);
        addQuestion(q16);

        String qstring17 = "def printList():\n" +
                "\tli=list()\n" +
                "\tfor i in range(1,5):\n" +
                "\t\tli.append(i**2)\n" +
                "\tprint li\n" +
                "\t\t\n" +
                "\n" +
                "printList()";
        Question q17 = new Question(qstring17,
                "[1, 2, 3, 4, 5]",
                "[1, 4, 9, 16, 25]",
                "[1, 4, 9, 16]",
                3);
        addQuestion(q17);

        String qstring18 = "def printList():\n" +
                "\tli=list()\n" +
                "\tfor i in range(1,21):\n" +
                "\t\tli.append(i**2)\n" +
                "\tprint li[:5]\n" +
                "\t\t\n" +
                "\n" +
                "printList()";
        Question q18 = new Question(qstring18,
                "[1, 2, 3, 4, 5]",
                "[1, 4, 9, 16, 25]",
                "25",
                2);
        addQuestion(q18);


        String qstring19 = "def printList():\n" +
                "\tli=list()\n" +
                "\tfor i in range(1,21):\n" +
                "\t\tli.append(i**2)\n" +
                "\tprint li[-5:]\n" +
                "\t\t\n" +
                "\n" +
                "printList()";
        Question q19 = new Question(qstring19,
                "[289, 324, 361, 400, 441]",
                "[1, 4, 9, 16, 25]",
                "[256, 289, 324, 361, 400]",
                3);
        addQuestion(q19);


        String qstring20 = "def printList():\n" +
                "\tli=list()\n" +
                "\tfor i in range(1,8):\n" +
                "\t\tli.append(i**2)\n" +
                "\tprint li[5:]\n" +
                "\t\t\n" +
                "\n" +
                "printList()";
        Question q20 = new Question(qstring20,
                "[36, 49]",
                "[1, 4, 9, 16, 25]",
                "[36, 49, 64]",
                1);
        addQuestion(q20);


        String qstring21 = "def printTuple():\n" +
                "\tli=list()\n" +
                "\tfor i in range(1,5):\n" +
                "\t\tli.append(i**2)\n" +
                "\tprint tuple(li)\n" +
                "\t\t\n" +
                "printTuple()";
        Question q21 = new Question(qstring21,
                "[1, 4, 9, 16]",
                "[1, 4, 9, 16, 25]",
                "(1, 4, 9, 16)",
                3);
        addQuestion(q21);


        String qstring22 = "tp=(1,2,3,4,5,6,7,8,9,10)\n" +
                "li=list()\n" +
                "for i in tp:\n" +
                "\tif tp[i]%2==0:\n" +
                "\t\tli.append(tp[i])\n" +
                "\n" +
                "tp2=tuple(li)\n" +
                "print tp2";
        Question q22 = new Question(qstring22,
                "(2, 4, 6, 8, 10)",
                "(1, 3, 5, 7, 9)",
                "[2, 4, 6, 8, 10]",
                1);
        addQuestion(q22);

        String qstring23 = "s= \"YEs\"\n" +
                "if s==\"yes\" or s==\"YES\" or s==\"Yes\":\n" +
                "    print \"Yes\"\n" +
                "else:\n" +
                "    print \"No\"";
        Question q23 = new Question(qstring23,
                "Yes",
                "No",
                "YEs",
                2);
        addQuestion(q23);

        String qstring24 = "li = [1,2,3,4,5,6,7,8,9,10]\n" +
                "evenNumbers = filter(lambda x: x%2==0, li)\n" +
                "print evenNumbers";
        Question q24 = new Question(qstring24,
                "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]",
                "[2, 4, 6, 8, 10]",
                "[1, 3, 5, 7, 9]",
                2);
        addQuestion(q24);


        String qstring25 = "li = [1,2,3,4,5]\n" +
                "squaredNumbers = map(lambda x: x**2, li)\n" +
                "print squaredNumbers";
        Question q25 = new Question(qstring25,
                "[1, 2, 3, 4, 5]",
                "[2, 4]",
                "[1, 4, 9, 16, 25]",
                3);
        addQuestion(q25);


        String qstring26 = "li = [1,2,3,4,5,6,7,8,9,10]\n" +
                "evenNumbers = map(lambda x: x**2, filter(lambda x: x%2==0, li))\n" +
                "print evenNumbers";
        Question q26 = new Question(qstring26,
                "[1, 4, 9, 16, 25, 36, 49, 64, 81, 100]",
                "[4, 16, 36, 64, 100]",
                "[2, 4, 6, 8, 10]",
                2);
        addQuestion(q26);


        String qstring27 = "class Circle(object):\n" +
                "    def __init__(self, r):\n" +
                "        self.radius = r\n" +
                "\n" +
                "    def area(self):\n" +
                "        return self.radius**2*3.14\n" +
                "\n" +
                "aCircle = Circle(2)\n" +
                "print aCircle.area()";
        Question q27 = new Question(qstring27,
                "12.56",
                "6.28",
                "4",
                1);
        addQuestion(q27);


        String qstring28 = "class Shape(object):\n" +
                "    def __init__(self):\n" +
                "        pass\n" +
                "\n" +
                "    def area(self):\n" +
                "        return 0\n" +
                "\n" +
                "class Square(Shape):\n" +
                "    def __init__(self, l):\n" +
                "        Shape.__init__(self)\n" +
                "        self.length = l\n" +
                "\n" +
                "    def area(self):\n" +
                "        return self.length*self.length\n" +
                "\n" +
                "aSquare= Square(3)\n" +
                "print aSquare.area()";
        Question q28 = new Question(qstring28,
                "0",
                "3",
                "9",
                3);
        addQuestion(q28);


        String qstring29 = "import re\n" +
                "emailAddress = john@google.com\n" +
                "pat2 = \"(\\w+)@((\\w+\\.)+(com))\"\n" +
                "r2 = re.match(pat2,emailAddress)\n" +
                "print r2.group(1)";
        Question q29 = new Question(qstring29,
                "john",
                "google",
                ".com",
                1);
        addQuestion(q29);


        String qstring30 = "import re\n" +
                "emailAddress = john@google.com\n" +
                "pat2 = \"(\\w+)@((\\w+\\.)+(com))\"\n" +
                "r2 = re.match(pat2,emailAddress)\n" +
                "print r2.group(2)";
        Question q30 = new Question(qstring30,
                "john",
                "google",
                ".com",
                2);
        addQuestion(q30);

        String qstring31 = "import re\n" +
                "s = \"2 cats and 3 dogs\"\n" +
                "print re.findall(\"\\d+\",s)";
        Question q31 = new Question(qstring31,
                "2 cats and 3 dogs",
                "['2', '3']",
                "d",
                2);
        addQuestion(q31);


        String qstring32 = "n=int(5)\n" +
                "sum=0.0\n" +
                "for i in range(1,n+1):\n" +
                "    sum += float(float(i)/(i+1))\n" +
                "print sum";
        Question q32 = new Question(qstring32,
                "3.55",
                "0.2",
                "1.5",
                1);
        addQuestion(q32);

        String qstring33 = "def f(n):\n" +
                "    if n==0:\n" +
                "        return 0\n" +
                "    else:\n" +
                "        return f(n-1)+100\n" +
                "\n" +
                "n=int(5)\n" +
                "print f(n)";
        Question q33 = new Question(qstring33,
                "105",
                "104",
                "500",
                3);
        addQuestion(q33);


        String qstring34 = "def f(n):\n" +
                "    if n == 0: return 0\n" +
                "    elif n == 1: return 1\n" +
                "    else: return f(n-1)+f(n-2)\n" +
                "\n" +
                "n=int(8)\n" +
                "print f(n)";
        Question q34 = new Question(qstring34,
                "8",
                "21",
                "15",
                2);
        addQuestion(q34);

        String qstring35 = "def f(n):\n" +
                "    if n == 0: return 0\n" +
                "    elif n == 1: return 1\n" +
                "    else: return f(n-1)+f(n-2)\n" +
                "\n" +
                "n=int(7)\n" +
                "values = [str(f(x)) for x in range(0, n+1)]\n" +
                "print \",\".join(values)";
        Question q35 = new Question(qstring35,
                "0,1,2,3,4,5,6,7",
                "13",
                "0,1,1,2,3,5,8,13",
                3);
        addQuestion(q35);

        String qstring36 = "def EvenGenerator(n):\n" +
                "    i=0\n" +
                "    while i<=n:\n" +
                "        if i%2==0:\n" +
                "            yield i\n" +
                "        i+=1\n" +
                "\n" +
                "\n" +
                "n=int(10)\n" +
                "values = []\n" +
                "for i in EvenGenerator(n):\n" +
                "    values.append(str(i))\n" +
                "\n" +
                "print \",\".join(values)";
        Question q36 = new Question(qstring36,
                "0,2,4,6,8,10",
                "0,1,2,3,4,5,6,7,8,9,10",
                "11",
                1);
        addQuestion(q36);


        String qstring37 = "def NumGenerator(n):\n" +
                "    for i in range(n+1):\n" +
                "        if i%5==0 and i%7==0:\n" +
                "            yield i\n" +
                "\n" +
                "n=int(50)\n" +
                "values = []\n" +
                "for i in NumGenerator(n):\n" +
                "    values.append(str(i))\n" +
                "\n" +
                "print \",\".join(values)";
        Question q37 = new Question(qstring37,
                "0,5,7,10,14,20,21,25,28,30,35,40,42,45,49,50",
                "0,35",
                "5,7",
                2);
        addQuestion(q37);

        String qstring38 = "li = [2,4,6,9]\n" +
                "for i in li:\n" +
                "    assert i%2==0";
        Question q38 = new Question(qstring38,
                "True",
                "Null",
                "AssertionError",
                3);
        addQuestion(q38);

        String qstring39 = "expression = \"3+5\"\n" +
                "print eval(expression)";
        Question q39 = new Question(qstring39,
                "35",
                "3+5",
                "8",
                3);
        addQuestion(q39);

        String qstring40 = "import math\n" +
                "def bin_search(li, element):\n" +
                "    bottom = 0\n" +
                "    top = len(li)-1\n" +
                "    index = -1\n" +
                "    while top>=bottom and index==-1:\n" +
                "        mid = int(math.floor((top+bottom)/2.0))\n" +
                "        if li[mid]==element:\n" +
                "            index = mid\n" +
                "        elif li[mid]>element:\n" +
                "            top = mid-1\n" +
                "        else:\n" +
                "            bottom = mid+1\n" +
                "\n" +
                "    return index\n" +
                "\n" +
                "li=[2,5,7,9,11,17,222]\n" +
                "print bin_search(li,11)";
        Question q40 = new Question(qstring40,
                "4",
                "5",
                "11",
                1);
        addQuestion(q40);

        String qstring41 = "li = [12,24,35,24,88,120,155]\n" +
                "li = [x for x in li if x!=24]\n" +
                "print li";
        Question q41 = new Question(qstring41,
                "[24,24]",
                "[12,35,88,120,155]",
                "[12,24,35,24,88,120,155]",
                2);
        addQuestion(q41);

        String qstring42 = "set1=set([1,3,6,78,35,55])\n" +
                "set2=set([12,24,35,24,88,120,155])\n" +
                "set1 &= set2\n" +
                "li=list(set1)\n" +
                "print li";
        Question q42 = new Question(qstring42,
                "[1,3,6,78,35,55,12,24,88,120,155]",
                "[1,3,6,78,35,55,35]",
                "[35]",
                3);
        addQuestion(q42);


        String qstring43 = "def removeDuplicate( li ):\n" +
                "    newli=[]\n" +
                "    seen = set()\n" +
                "    for item in li:\n" +
                "        if item not in seen:\n" +
                "            seen.add( item )\n" +
                "            newli.append(item)\n" +
                "\n" +
                "    return newli\n" +
                "\n" +
                "li=[12,24,35,24,88,120,155,88,120,155]\n" +
                "print removeDuplicate(li)";
        Question q43 = new Question(qstring43,
                "[12,24,35,88,120,155]",
                "[24,88,120,155]",
                "[12,24,35,24,88,120,155,88,120,155]",
                1);
        addQuestion(q43);


        String qstring44 = "class Person(object):\n" +
                "    def getGender( self ):\n" +
                "        return \"Unknown\"\n" +
                "\n" +
                "class Male( Person ):\n" +
                "    def getGender( self ):\n" +
                "        return \"Male\"\n" +
                "\n" +
                "class Female( Person ):\n" +
                "    def getGender( self ):\n" +
                "        return \"Female\"\n" +
                "\n" +
                "aMale = Female()\n" +
                "aFemale= Male()\n" +
                "print aMale.getGender()";
        Question q44 = new Question(qstring44,
                "Male",
                "Female",
                "Unknown",
                2);
        addQuestion(q44);

        String qstring45 = "dic = {}\n" +
                "s=\"abcdefgabc\"\n" +
                "for s in s:\n" +
                "    dic[s] = dic.get(s,0)+1\n" +
                "print ', '.join(['%s:%s' % (k, v) for k, v in dic.items()])";
        Question q45 = new Question(qstring45,
                "a:1, b:2, c:3, d:4, e:5, f:6, g:7, a:8, b:9, c:10",
                "a:2,c:2,b:2,e:1,d:1,g:1,f:1",
                "a:2, c:2, b:2, e:1, d:1, g:1, f:1",
                3);
        addQuestion(q45);

        String qstring46 = "s=\"rise to vote sir\"\n" +
                "s = s[::-1]\n" +
                "print s";
        Question q46 = new Question(qstring46,
                "r",
                "ris etov ot esir",
                "sir",
                2);
        addQuestion(q46);


        String qstring47 = "s=\"H1e2l3l4o5w6o7r8l9d\"\n" +
                "s = s[::2]\n" +
                "print s";
        Question q47 = new Question(qstring47,
                "1",
                "123456789",
                "Helloworld",
                3);
        addQuestion(q47);

        String qstring48 = "import itertools\n" +
                "print list(itertools.permutations([1,2,3]))";
        Question q48 = new Question(qstring48,
                "[(1, 2, 3), (1, 3, 2), (2, 1, 3), (2, 3, 1), (3, 1, 2), (3, 2, 1)]",
                "[(1, 2, 3), (2,1,3), (3,2,1)]",
                "[(1, 2), (1, 3), (2, 3)]",
                1);
        addQuestion(q48);

        String qstring49 = "def solve(numheads,numlegs):\n" +
                "    ns='No solutions!'\n" +
                "    for i in range(numheads+1):\n" +
                "        j=numheads-i\n" +
                "        if 2*i+4*j==numlegs:\n" +
                "            return i,j\n" +
                "    return ns,ns\n" +
                "\n" +
                "numheads=35\n" +
                "numlegs=94\n" +
                "solutions=solve(numheads,numlegs)\n" +
                "print solutions";
        Question q49 = new Question(qstring49,
                "(18, 23)",
                "(23, 12)",
                "No Solution",
                2);
        addQuestion(q49);

        String qstring50 = "from operator import itemgetter, attrgetter\n" +
                "s = [\"Tom,19,80\", \"John,20,90\", \"Jony,17,91\", \"Jony,17,93\"]\n" +
                "l = []\n" +
                "for item in s:\n" +
                "    l.append(tuple(item.split(\",\")))\n" +
                "\n" +
                "print sorted(l, key=itemgetter(0,1,2))";
        Question q50 = new Question(qstring50,
                "(\"Tom,19,80\", \"John,20,90\", \"Jony,17,91\", \"Jony,17,93\")",
                "[('Tom', '19', '80'), ('John', '20', '90'), ('Jony', '17', '91'), ('Jony', '17', '93')]",
                "[('John', '20', '90'), ('Jony', '17', '91'), ('Jony', '17', '93'), ('Tom', '19', '80')]",
                3);
        addQuestion(q50);

    }

    private void addQuestion(Question question){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER, question.getAnswer());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME,
                null);

        if(c.moveToFirst()){
            do{
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswer(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER)));
                questionList.add(question);
            }while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}
