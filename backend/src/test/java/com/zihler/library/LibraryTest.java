package com.zihler.library;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class LibraryTest {
    private MockMvc mvc;
    @InjectMocks
    private Library library;


    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(library)
                .build();
    }

    @Ignore
    @Test
    public void getAllBooks() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .get("/library/books")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(
                "[[\"0\",\"Refactoring\",\"Martin Fowler,Kent Beck\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=UTgFCAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"1\",\"Refactoring to patterns\",\"Joshua Kerievsky\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=h2sdNbKW65gC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"2\",\"Refactoring\",\"Martin Fowler\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=ffwePwAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"],[\"3\",\"Clean Code - Refactoring, Patterns, Testen und Techniken für sauberen Code\",\"Robert C. Martin\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=7pVbAgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"4\",\"Refactoring in der Ontologiegetriebenen Softwareentwicklung\",\"Erik Tittel\",\"FOR_SALE\",\"http://books.google.com/books/content?id=V51DDt1GEVMC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"5\",\"Refactoring oder: Wie Sie das Design vorhandener Software verbessern\",\"Martin Fowler\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=UUpIAAAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"],[\"6\",\"Refactoring in Large Software Projects\",\"Martin Lippert,Stephen Roock\",\"FOR_SALE\",\"http://books.google.com/books/content?id=bCEYuB83ROcC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"7\",\"Refactoring Workbook\",\"William C. Wake\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=KE-zdnHQehYC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"8\",\"Genome Refactoring\",\"Natalie Kuldell,Neal Lerner\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=PGSFbBNTo4gC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"9\",\"Refactoring with Relations. A New Method for Refactoring Object-Oriented Software\",\"Sergio Pissanetzky, Jr.\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=9b5KEn052usC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"10\",\"Clean Code - Refactoring, Patterns, Testen und Techniken für sauberen Code\",\"Robert C. Martin\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=7pVbAgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"11\",\"Mehr als Clean Code\",\"Andreas Lennartz\",\"FOR_SALE\",\"http://books.google.com/books/content?id=_UeoBAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"12\",\"Clean Code\",\"Robert C. Martin\",\"FOR_SALE\",\"http://books.google.com/books/content?id=_i6bDeoCQzsC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"13\",\"Clean Code in Python\",\"Mariano Anaya\",\"FOR_SALE\",\"http://books.google.com/books/content?id=ZB9sDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"14\",\"Clean Code Development\",\"Karsten Samaschke\",\"NOT_FOR_SALE\",\"/assets/images/sample-book.png\"],[\"15\",\"Design Patterns\",\"Erich Gamma,Richard Helm,Ralph Johnson,John Vlissides\",\"FOR_SALE\",\"http://books.google.com/books/content?id=lYyXBgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"16\",\"Clean Coder\",\"Robert C. Martin\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=rHBZAwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"17\",\"The Beauty of Functional Code\",\"Peter Achten,Pieter Koopman\",\"FOR_SALE\",\"http://books.google.com/books/content?id=1Sm6BQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"18\",\"The Code of Federal Regulations of the United States of America\",\"\",\"FREE\",\"http://books.google.com/books/content?id=pgU7AAAAIAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"19\",\"Code Complete\",\"Steve McConnell\",\"FOR_SALE\",\"http://books.google.com/books/content?id=LpVCAwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"20\",\"eXtreme programming in action\",\"Martin Lippert,Stefan Roock,Henning Wolf\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=IHtGAAAAYAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"],[\"21\",\"Extreme Programming\",\"Kent Beck\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=79dSpPDQdLYC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"22\",\"Cybersecurity: The Essential Body Of Knowledge\",\"Dan Shoemaker,Wm. Arthur Conklin\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=AqRl1JARvIsC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"23\",\"OPTIMIZATION METHODS FOR ENGINEERS\",\"N.V.S. Raju\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=-r1nAgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"24\",\"Implantando Governança Ágil - MAnGve\",\"Alexandre Luna\",\"FOR_SALE\",\"http://books.google.com/books/content?id=zmeECgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"25\",\"Programming Proverbs\",\"Henry F. Ledgard\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=e9AmAAAAMAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"],[\"26\",\"Der Pragmatische Programmierer\",\"Andrew Hunt,David Thomas\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=wzvjQwAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"],[\"27\",\"Expert-C-Programmierung\",\"Peter Van der Linden\",\"NOT_FOR_SALE\",\"/assets/images/sample-book.png\"],[\"28\",\"Structured programming in PL/C\",\"Gerald M. Weinberg,Norie Yasukawa,Robert Marcus\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=FdtWAAAAMAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"],[\"29\",\"Popular Computing\",\"\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=RRopAQAAMAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"],[\"30\",\"Agiles IT-Projektmanagement mit Scrum\",\"Jonas Tewolde\",\"FOR_SALE\",\"http://books.google.com/books/content?id=9oCc9O7yFJIC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"31\",\"Agiles Projektmanagement mit Scrum\",\"Eric Dreyer\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=i1memNPPqUMC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"32\",\"Scrum - verstehen und erfolgreich einsetzen\",\"Stefan Roock,Henning Wolf\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=-NlNDAAAQBAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"],[\"33\",\"Scrum\",\"Boris Gloger\",\"FOR_SALE\",\"http://books.google.com/books/content?id=NfGgDAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"34\",\"Scrum\",\"Roman Pichler\",\"FOR_SALE\",\"http://books.google.com/books/content?id=J6h3DwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"35\",\"Mit Scrum zum gewünschten System\",\"Joachim Goll,Daniel Hommel\",\"FOR_SALE\",\"http://books.google.com/books/content?id=ZzMwCgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"36\",\"Scrum – Einführung in der Unternehmenspraxis\",\"Dominik Maximini\",\"FOR_SALE\",\"http://books.google.com/books/content?id=9xtJDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"37\",\"Agiles Projektmanagement - Agilität und Scrum im klassischen Projektumfeld\",\"Jörg Preußig\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=Gp4qDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"38\",\"Analyse der Möglichkeiten für den Wissenstransfer von Business in die Scrum Teams\",\"Allen Hintermann\",\"FOR_SALE\",\"http://books.google.com/books/content?id=yekuqz90aU4C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"39\",\"Agile Softwareentwicklung\",\"Mike Cohn\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=AAECyPcN3UoC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"40\",\"Agile Organisationen\",\"André Häusling\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=QBQ4DwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"41\",\"Agile Softwareentwicklung\",\"Mike Cohn\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=AAECyPcN3UoC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"42\",\"Agile Moderation\",\"Thomas Tiller\",\"FOR_SALE\",\"http://books.google.com/books/content?id=619-DwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"43\",\"Agile Prozesse: Von XP über Scrum bis MAP\",\"Eckhart Hanser\",\"FOR_SALE\",\"http://books.google.com/books/content?id=G29LC_Kt2mkC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"44\",\"Agile Testing\",\"Manfred Baumgartner,Martin Klonk,Helmut Pichler,Richard Seidl,Siegfried Tanczos\",\"FOR_SALE\",\"http://books.google.com/books/content?id=xag7DwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"45\",\"Agile Produktentwicklung\",\"Axel Schröder\",\"FOR_SALE\",\"http://books.google.com/books/content?id=UcFwDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"46\",\"Der agile Festpreis\",\"Andreas Opelt,Boris Gloger,Wolfgang Pfarl,Ralf Mittermayr\",\"FOR_SALE\",\"http://books.google.com/books/content?id=rejwAwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"47\",\"SOA für agile Unternehmen\",\"Wolfgang Beinhauer\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=TufMCNwS9HgC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"48\",\"Agile Führung\",\"Stefan Scherber,Michael Lang\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=h-PGBgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"49\",\"Agile Techniken für klassisches Projektmanagement\",\"Nils Pröpper\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=Z9uqdlQSaOEC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"50\",\"Lean Management\",\"Werner Pfeiffer,Enno Weiss\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=xy47RgxZ3_oC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"51\",\"Lean Six Sigma\",\"Armin Töpfer\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=QariSuW7xcoC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"52\",\"Lean TPM\",\"Andreas Reitz\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=0Qh_Lg5foWkC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"53\",\"Change Management. Übertragung von Lean-Methoden und -Werkzeugen von der Produktion in den Verwaltungsbereich\",\"Tuptus Virtual\",\"FOR_SALE\",\"http://books.google.com/books/content?id=shKO3HHYCM4C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"54\",\"Fourth Lean Management Summit\",\"\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=vxfCyIrIHDAC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"55\",\"Die Einführung von lean management als Betriebsänderung im Sinne des § 111 BetrVG und die Konsequenzen für den Unternehmer in Form von Interessenausgleich und Sozialplan gem. § 112 BetrVG\",\"Thomas Hölscher\",\"FOR_SALE\",\"http://books.google.com/books/content?id=NOL-09aJVtEC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"56\",\"Lean-Management\",\"Wilhelm Schultheiß\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=jwtmJjj9iwYC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"57\",\"Lean Six Sigma bei Finanzdienstleistern\",\"Roland Schurig\",\"FOR_SALE\",\"http://books.google.com/books/content?id=NvRXEFdx2GwC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"58\",\"Six Sigma+Lean Toolset\",\"Olin Roenpage,Christian Staudter,Renata Meran,Alexander John,Carmen Beernaert\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=ty6ojSp-HiwC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"],[\"59\",\"Lean Interim\",\"Dietmar Dold\",\"NOT_FOR_SALE\",\"http://books.google.com/books/content?id=sTQQVltxv_oC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"]]",
                response.getContentAsString()
        );
    }

    @Ignore
    @Test

    public void getSubsetOfAllBooks() throws Exception {
        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders
                .post("/library/fee")
                .content("[\"hansmeier\", \"0 0\", \"4 1\", \"18 2\"]")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();

        String expected = new StringBuilder()
                .append("[\"Rental Record for hansmeier\\n")
                .append("\\t'Refactoring' by 'Martin Fowler,Kent Beck' for 0 days: \\t2.0 $\\n")
                .append("\\t'Refactoring in der Ontologiegetriebenen Softwareentwicklung' by 'Erik Tittel' for 1 days: \\t3.0 $\\n")
                .append("\\t'The Code of Federal Regulations of the United States of America' by '' for 2 days: \\t1.5 $\\n")
                .append("You owe 6.5 $")
                .append("\\nYou earned 3 frequent renter points\\n\"]")
                .toString();

        assertEquals(expected, response.getContentAsString());
    }

    @Ignore
    @Test
    public void getSubsetOfAllBooks2() throws Exception {
        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders
                .post("/library/fee")
                .content("[\"hansmeier\", \"0 3\", \"4 1\", \"18 4\"]")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();

        String expected = new StringBuilder()
                .append("[\"Rental Record for hansmeier\\n")
                .append("\\t'Refactoring' by 'Martin Fowler,Kent Beck' for 3 days: \\t3.5 $\\n")
                .append("\\t'Refactoring in der Ontologiegetriebenen Softwareentwicklung' by 'Erik Tittel' for 1 days: \\t3.0 $\\n")
                .append("\\t'The Code of Federal Regulations of the United States of America' by '' for 4 days: \\t3.0 $\\n")
                .append("You owe 9.5 $")
                .append("\\nYou earned 4 frequent renter points\\n\"]")
                .toString();

        assertEquals(expected, response.getContentAsString());
    }
}