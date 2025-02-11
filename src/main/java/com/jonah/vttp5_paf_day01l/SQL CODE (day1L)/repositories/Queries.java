package com.jonah.vttp5_paf_day01l.repositories;

public class Queries {
    
    public static final String SQL_SELECT_GAME = """
            select * from game limit 10
            """;

    public static final String SQL_SELECT_GAME_LIMIT = """
            select * from game limit ?
            """;

public static final String SQL_SELECT_BOOK_LIMIT = """
            select * from kindle limit 10
            """;


            public static final String SQL_SELECT_BOOK_AUTHOR_LIMIT = """
            select * from kindle where author like ? limit ?
            """;

            public static final String SQL_SELECT_BOOK_ASIN = """
            select * from kindle where asin like ?
            """;

            public static final String SQL_AUTHOR_RANKINGS =  """
        select author, avg(stars) as avg_stars, count(asin) as count
                from kindle
                where author != ''
                group by author
                having avg(stars) > ? 
                order by count(asin) desc 
                limit 10
;
                            """;


        public static final String SQL_ALL_RSVPS = """
                        select * from rsvptable;
                        """;

        public static final String SQL_FIND_RSVP_FROM_NAME = """
                        select * from rsvptable where name like ?;
                        """;


        public static final String SQL_ADD_RSVP_TO_DATABASE = """
                        insert into rsvptable
(email,phone,confirmDate,comments,name)
values
(?,?,?,?,?);
                        """;

        public static final String SQL_COUNT_RSPVS = """
                        select COUNT(*) as rsvpCount from rsvptable;
                        """;

        public static final String SQL_DELETE_RSVP = """
                        DELETE FROM rsvptable where email = ?;
                        """;
}
