/**
 * Main
 * Author: Feng Zhang
 * 11/23/2016
 * window 10 64bit, eclipse
 * This is main class. 
 */
package HW5;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		HashTable<RomanNumeral> hashsc = 
				new HashSC<RomanNumeral>(new RomanValueHasher(), new RomanValueComparator());
		HashTable<RomanNumeral> hashqp = 
				new HashQP<RomanNumeral>(new RomanStringHasher(), new RomanStringComparator());
		
		RomanNumeral last = fillbothHashTables(hashsc, hashqp);
		
		runHash(hashsc, last);	//call runHash
		runHash(hashqp, last);	//call runHash
		
		System.out.println("HashSC with int value key has: ");
		hashsc.displayTable();
		System.out.println("HashQP with String key has:");
		hashqp.displayTable();
		
		System.out.println();
		System.out.println("HashSC statistics:\n");
		hashsc.displayStatistics();
		System.out.println("HashQP statistics:\n");
		hashqp.displayStatistics();
		
		System.out.println();
		testHashTables(hashsc, hashqp, last);
		
		System.out.println();
		System.out.println("HashSC statistics:");
		hashsc.displayStatistics();
		System.out.println("HashQP statistics:");
		hashqp.displayStatistics();
		
	}
	public static RomanNumeral fillbothHashTables(HashTable<RomanNumeral> HashSC,
            HashTable<RomanNumeral> HashQP) {		
			int numOfEntries = (int) (Math.random()*201) + 100;
			
			RomanNumeral last = null;
			for (int i = 0; i < numOfEntries; ++i) {
				while(true) {
					int num = (int) (Math.random()*5000) + 1;
					RomanNumeral romanNum = new RomanNumeral(num);
					
					if (HashSC.insert(romanNum) && HashQP.insert(romanNum)) {
						last = romanNum;
						break;
					}
				}
			}
			return last;
}
	
	public static void runHash(HashTable<RomanNumeral> hashtable, RomanNumeral romannumeral){
		RomanNumeral roman = new RomanNumeral(5001);
		
		RomanNumeral romanNum = hashtable.getEntry(roman);
		if(romanNum == null)
			System.out.println(roman.toString()+" not found (good!)" );
		else
			System.out.println(roman.toString()+" found ");
		
		boolean delete = hashtable.remove(roman);
		if(delete)
			System.out.println(roman.toString() + " deleted ");
		else
			System.out.println(roman.toString() + " not deleted (good!)");
		
		boolean insert = hashtable.insert(romannumeral);
		if (insert)
			System.out.println(romannumeral.toString()+" inserted" );
		else
			System.out.println(romannumeral.toString()+" not inserted (good!)");
	}
	
	public static void testHashTables(HashTable<RomanNumeral> tableSC,
			HashTable<RomanNumeral> tableQP,
			RomanNumeral lastRoman)
	{
		RomanNumeral targetRoman = new RomanNumeral(lastRoman.getValue()); // make copy
		RomanNumeral tempRoman;
		System.out.println("Calling getEntry in HashSC for "+ targetRoman);
		tempRoman = tableSC.getEntry(targetRoman);
		
		if( tempRoman != null )
		{
			System.out.println("Retrieved in HashSC, RomanNumeral: " + tempRoman + 
						", now trying to delete it");
			// now delete it 
			if( tableSC.remove(targetRoman))
				System.out.println("Successfully removed from HashSC: " + targetRoman);
			else
				System.out.println("Unsuccessful attempt to remove from HashSC: " + targetRoman);
			if( tableSC.remove(targetRoman))
				System.out.println("Successfully removed from HashSC AGAIN (bad): " + targetRoman);
			else
				System.out.println("Unsuccessful attempt to remove AGAIN from HashSC (good): " + targetRoman);
		}
		else
			System.out.println("Error in HashSC: can't retrieve "+ targetRoman);
			
		System.out.println("Calling getEntry in HashQP for "+ targetRoman);
		tempRoman = tableQP.getEntry(targetRoman); // should be the same object as in HashSC
		if( tempRoman != null )
		{
			System.out.println("Retrieved in HashQP, RomanNumeral: " + tempRoman + 
					", now trying to delete it");
		// now delete it 
			if( tableQP.remove(targetRoman))
				System.out.println("Successfully removed from HashQP: " + targetRoman);
			else
				System.out.println("Unsuccessful attempt to remove from HashQP: " + targetRoman);
			if( tableQP.remove(targetRoman))
				System.out.println("Successfully removed AGAIN from HashQP (bad): " + targetRoman);
			else
				System.out.println("Unsuccessful attempt to remove AGAIN from HashQP (good): " + targetRoman);
		}else
			System.out.println("Error in HashQP: can't retrieve "+ targetRoman);
			
		}// end testHashTables
	} 

/**
MMMMMI = 5001 not found (good!)
MMMMMI = 5001 not deleted (good!)
MMMCMXCI = 3991 not inserted (good!)
MMMMMI = 5001 not found (good!)
MMMMMI = 5001 not deleted (good!)
MMMCMXCI = 3991 not inserted (good!)
HashSC with int value key has: 
0: ----
1: ----
2:MMDCXXI = 2621
3:MMCMXIII = 2913 -> MMCCXXXIV = 2234
4:CMLXXIV = 974 -> MMMMCMLI = 4951 -> MMMMDLXIII = 4563
5:MMMDCCCLXXXV = 3885
6:MMCCCXXXIV = 2334
7:MMDCCCXX = 2820 -> MCLXXI = 1171
8: ----
9: ----
10:CCCXCVIII = 398
11:MMCXLV = 2145 -> MCCLXXII = 1272
12:DCCCLXXXV = 885
13:MML = 2050
14:MCCLXXV = 1275 -> MMMCMXCI = 3991
15:MDCCLXI = 1761 -> CDIII = 403
16:DXCVIII = 598 -> MMMMDLXXV = 4575
17:MMDCXXXVI = 2636
18: ----
19:MMMCCXX = 3220 -> MMMMXCIII = 4093
20: ----
21: ----
22:MMMMDCCLXXV = 4775 -> DCCCXCV = 895
23: ----
24: ----
25:MMMMII = 4002
26:MMDXLVIII = 2548
27: ----
28:CCCXIX = 319 -> MMLXV = 2065
29:MMCLXIII = 2163
30:XXX = 30 -> MDLXXXII = 1582
31:MMMCDXXVI = 3426
32:MMLXIX = 2069
33: ----
34:MCCCXCII = 1392 -> MMDCCCXLVII = 2847 -> CXXXI = 131
35:MDLXXXVII = 1587 -> XXXV = 35 -> MDCCCLXXVIII = 1878
36: ----
37:MMMDCXXVI = 3626 -> MVII = 1007
38: ----
39:MMMDCCCXXII = 3822
40:MMMMCCCVIII = 4308
41:DCCCXVII = 817 -> MCMLXXXI = 1981
42: ----
43:MMMMCMXC = 4990
44:DCXXVI = 626
45:MMMCCCXLIII = 3343
46:MMDLXVIII = 2568 -> CMXIX = 919 -> MMMCCCXLIV = 3344 -> MMMMCCCXIV = 4314
47:MDXCIX = 1599
48:CCCXXXIX = 339
49:MMMDCCCXXXII = 3832 -> MMMMCMXCVI = 4996
50:CMXXIII = 923
51: ----
52:MMDCCCLXV = 2865
53:MMMMCCCXXI = 4321 -> MMCCLXXXIV = 2284
54: ----
55:MMMDCCXLI = 3741 -> MDX = 1510 -> MMMMXXXII = 4032 -> MMDCCLXXI = 2771
56:MMMCCCLIV = 3354
57: ----
58: ----
59:MMMMCCCXXVII = 4327
60: ----
61:MMMCCCLIX = 3359
62:MMCMLXXII = 2972
63:DXLVIII = 548
64:MMCCXCV = 2295
65: ----
66: ----
67:MMDLXXXIX = 2589
68:MCCCXXIX = 1329 -> MMDCCCLXXXI = 2881
69:MXXXIX = 1039
70:MMMCCCLXVIII = 3368
71:MDCXXIII = 1623 -> MDXXVI = 1526 -> CDLIX = 459
72: ----
73: ----
74: ----
75:MMMMCCXLVI = 4246
76:MMDXCVIII = 2598 -> MMMLXXXIII = 3083 -> MMXVI = 2016 -> MMMMCMXXVI = 4926
77: ----
78:CDLXVI = 466 -> MMDCCCXCI = 2891
79: ----
80:MMDCCXCVI = 2796
81:MMMMCMXXXI = 4931
82:MMMMCMXXXII = 4932
83:DCCCLIX = 859
84: ----
85:MMMMDCXLIV = 4644
86:DCCCLXII = 862
87:MMXXVII = 2027 -> MMMDLXXIX = 3579
88: ----
89:MMMMDLI = 4551
90: ----
91:MMMDLXXXIII = 3583 -> MDCXLIII = 1643 -> DCLXXIII = 673
92: ----
93:MMMMCDLVIII = 4458 -> MMMCDLXXXVIII = 3488 -> MMDCXV = 2615
94:MMDXIX = 2519
95:MMCDXXIII = 2423
96:MCMXXXIX = 1939 -> MMDCXVIII = 2618
HashQP with String key has:
0: MMDXIX = 2519
1: ----
2: ----
3: ----
4: ----
5: MMMDCXXVI = 3626
6: ----
7: MMDXCVIII = 2598
8: ----
9: ----
10: ----
11: ----
12: CMXXIII = 923
13: MMMMXXXII = 4032
14: ----
15: ----
16: CMXIX = 919
17: ----
18: ----
19: MDCXLIII = 1643
20: ----
21: ----
22: ----
23: ----
24: ----
25: CCCXCVIII = 398
26: ----
27: ----
28: ----
29: ----
30: ----
31: ----
32: ----
33: MMMMCCXLVI = 4246
34: MDX = 1510
35: CMLXXIV = 974
36: MMMDCCCXXXII = 3832
37: ----
38: MDXCIX = 1599
39: MDLXXXII = 1582
40: ----
41: ----
42: ----
43: MMMCDLXXXVIII = 3488
44: ----
45: ----
46: MMMDLXXIX = 3579
47: MMMMCCCXXVII = 4327
48: MDCXXIII = 1623
49: ----
50: ----
51: ----
52: ----
53: MMMMCMXCVI = 4996
54: ----
55: MMLXV = 2065
56: ----
57: ----
58: ----
59: ----
60: MMDCCCXCI = 2891
61: ----
62: CCCXIX = 319
63: MMMCCCLIV = 3354
64: ----
65: MMDCXVIII = 2618
66: MMMCCCLIX = 3359
67: ----
68: ----
69: DCCCLXII = 862
70: MMCCXXXIV = 2234
71: ----
72: ----
73: MMMCCCXLIV = 3344
74: ----
75: ----
76: ----
77: MMMMCCCVIII = 4308
78: MMDCCCLXXXI = 2881
79: ----
80: ----
81: MMMCCCXLIII = 3343
82: DCCCXCV = 895
83: MCMLXXXI = 1981
84: MMMCMXCI = 3991
85: ----
86: ----
87: MMMMDLXXV = 4575
88: ----
89: MMMCCXX = 3220
90: ----
91: ----
92: ----
93: ----
94: ----
95: ----
96: ----
97: ----
98: MMMMCMXXXII = 4932
99: ----
100: ----
101: ----
102: ----
103: ----
104: ----
105: ----
106: ----
107: ----
108: MMMMCCCXXI = 4321
109: ----
110: ----
111: MMDCXXXVI = 2636
112: ----
113: ----
114: ----
115: ----
116: ----
117: MMDXLVIII = 2548
118: DCCCLXXXV = 885
119: MMXVI = 2016
120: MMCCLXXXIV = 2284
121: CCCXXXIX = 339
122: MMMMCMLI = 4951
123: ----
124: ----
125: ----
126: ----
127: ----
128: ----
129: MMDCXXI = 2621
130: ----
131: ----
132: ----
133: MMCDXXIII = 2423
134: MMMMII = 4002
135: DCCCXVII = 817
136: ----
137: ----
138: ----
139: ----
140: ----
141: CDLIX = 459
142: MMDLXXXIX = 2589
143: ----
144: ----
145: ----
146: ----
147: ----
148: ----
149: ----
150: ----
151: MMMMDCCLXXV = 4775
152: ----
153: ----
154: MMMMCDLVIII = 4458
155: DCCCLIX = 859
156: ----
157: ----
158: ----
159: MCCCXXIX = 1329
160: ----
161: ----
162: ----
163: MMMMCMXC = 4990
164: MMDCCLXXI = 2771
165: MMDLXVIII = 2568
166: ----
167: MMMMDLI = 4551
168: ----
169: ----
170: ----
171: ----
172: ----
173: ----
174: ----
175: ----
176: MMCMXIII = 2913
177: CDLXVI = 466
178: ----
179: ----
180: ----
181: ----
182: ----
183: DXCVIII = 598
184: ----
185: ----
186: MMCCCXXXIV = 2334
187: ----
188: ----
189: ----
190: ----
191: ----
192: ----
193: ----
194: ----
195: ----
196: ----
197: ----
198: ----
199: ----
200: ----
201: ----
202: ----
203: ----
204: ----
205: ----
206: ----
207: ----
208: ----
209: ----
210: ----
211: MMDCCCXLVII = 2847
212: ----
213: ----
214: ----
215: ----
216: ----
217: ----
218: MMMMCMXXVI = 4926
219: MCMXXXIX = 1939
220: ----
221: ----
222: ----
223: ----
224: ----
225: ----
226: ----
227: ----
228: ----
229: ----
230: MMXXVII = 2027
231: ----
232: ----
233: ----
234: ----
235: MMCCXCV = 2295
236: MDLXXXVII = 1587
237: ----
238: ----
239: ----
240: ----
241: ----
242: MMCMLXXII = 2972
243: ----
244: ----
245: ----
246: ----
247: MDCCCLXXVIII = 1878
248: DCXXVI = 626
249: ----
250: ----
251: ----
252: MMCLXIII = 2163
253: ----
254: MCCLXXII = 1272
255: MMDCCCXX = 2820
256: ----
257: ----
258: ----
259: ----
260: ----
261: ----
262: ----
263: ----
264: ----
265: ----
266: ----
267: ----
268: ----
269: ----
270: ----
271: MXXXIX = 1039
272: MDXXVI = 1526
273: MMCXLV = 2145
274: ----
275: ----
276: MCCLXXV = 1275
277: MMMDLXXXIII = 3583
278: ----
279: MMMDCCXLI = 3741
280: ----
281: ----
282: ----
283: ----
284: MMLXIX = 2069
285: ----
286: MMMMDLXIII = 4563
287: ----
288: ----
289: ----
290: ----
291: ----
292: MMMMCMXXXI = 4931
293: DXLVIII = 548
294: ----
295: XXXV = 35
296: DCLXXIII = 673
297: ----
298: ----
299: ----
300: ----
301: ----
302: MMDCCCLXV = 2865
303: ----
304: ----
305: ----
306: ----
307: ----
308: ----
309: ----
310: ----
311: ----
312: ----
313: ----
314: ----
315: ----
316: ----
317: ----
318: ----
319: ----
320: ----
321: ----
322: ----
323: ----
324: ----
325: MMMDCCCLXXXV = 3885
326: MMMMDCXLIV = 4644
327: ----
328: ----
329: ----
330: ----
331: ----
332: MMMLXXXIII = 3083
333: ----
334: ----
335: ----
336: ----
337: ----
338: ----
339: ----
340: ----
341: ----
342: ----
343: ----
344: ----
345: ----
346: ----
347: ----
348: ----
349: XXX = 30
350: ----
351: MDCCLXI = 1761
352: MMDCCXCVI = 2796
353: ----
354: MML = 2050
355: CXXXI = 131
356: ----
357: ----
358: ----
359: MMMCDXXVI = 3426
360: MMMMCCCXIV = 4314
361: ----
362: ----
363: ----
364: ----
365: ----
366: ----
367: ----
368: ----
369: MMMMXCIII = 4093
370: MVII = 1007
371: ----
372: ----
373: ----
374: ----
375: ----
376: MCCCXCII = 1392
377: ----
378: ----
379: ----
380: ----
381: ----
382: ----
383: ----
384: ----
385: ----
386: MMMDCCCXXII = 3822
387: CDIII = 403
388: MMDCXV = 2615
389: ----
390: ----
391: MMMCCCLXVIII = 3368
392: ----
393: MCLXXI = 1171
394: ----
395: ----
396: ----

HashSC statistics:


In the HashSC class:

Table Size = 97
Number of entries = 106
Load factor = 1.092783505154639
Number of collisions = 58
Longest Linked List = 3
HashQP statistics:


In the HashQP class:

Table Size = 397
Number of entries = 106
Load factor = 0.26700251889168763
Number of collisions = 25
Longest Collision Run = 2

Calling getEntry in HashSC for MMMCMXCI = 3991
Retrieved in HashSC, RomanNumeral: MMMCMXCI = 3991, now trying to delete it
Successfully removed from HashSC: MMMCMXCI = 3991
Unsuccessful attempt to remove AGAIN from HashSC (good): MMMCMXCI = 3991
Calling getEntry in HashQP for MMMCMXCI = 3991
Retrieved in HashQP, RomanNumeral: MMMCMXCI = 3991, now trying to delete it
Successfully removed from HashQP: MMMCMXCI = 3991
Unsuccessful attempt to remove AGAIN from HashQP (good): MMMCMXCI = 3991

HashSC statistics:

In the HashSC class:

Table Size = 97
Number of entries = 105
Load factor = 1.0824742268041236
Number of collisions = 58
Longest Linked List = 3
HashQP statistics:

In the HashQP class:

Table Size = 397
Number of entries = 105
Load factor = 0.26448362720403024
Number of collisions = 28
Longest Collision Run = 2

 */

