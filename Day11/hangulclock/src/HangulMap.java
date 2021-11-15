public class HangulMap {

    private String[][] sourcemap = {
        {"한", "두", "세", "네", "다", "섯"},
        {"여", "섯", "일", "곱", "여", "덟"},
        {"아", "홉", "열", "한", "두", "시"},
        {"자", "이", "삼", "사", "오", "십"},
        {"정", "일", "이", "삼", "사", "육"},
        {"오", "오", "칠", "팔", "구", "분"},
    };

    private String[][] map = {
        {" ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " "},
    };

    public void printMap(String[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.printf("%3s", map[i][j]);
            }
            System.out.println("");
        }
    }

    public String[][] getMap() {
        return map;
    }

    public void setMap(String[][] map) {
        this.map = map;
    }

    public void setMap(int hour, int minute) {
        if (!((hour == 12 || hour == 24) && minute == 00)) {
            setHourMap(hour);
            setMinuteMap(minute);
        } else if (hour == 12) {
            this.map[4][0] = this.sourcemap[4][0];
            this.map[5][0] = this.sourcemap[5][0];
        } else {
            this.map[3][0] = this.sourcemap[3][0];
            this.map[4][0] = this.sourcemap[4][0];
        }

    }


    private void setMinuteMap(int minute) {
        String[][] minutemap;
        minutemap = this.map;
        minutemap[5][5] = this.sourcemap[5][5];
        switch (minute % 10) {
            case 1:
                minutemap[4][1] = this.sourcemap[4][1];
                break;
            case 2:
                minutemap[4][2] = this.sourcemap[4][2];
                break;
            case 3:
                minutemap[4][3] = this.sourcemap[4][3];
                break;
            case 4:
                minutemap[4][4] = this.sourcemap[4][4];
                break;
            case 5:
                minutemap[5][1] = this.sourcemap[5][1];
                break;
            case 6:
                minutemap[4][5] = this.sourcemap[4][5];
                break;
            case 7:
                minutemap[5][2] = this.sourcemap[5][2];
                break;
            case 8:
                minutemap[5][3] = this.sourcemap[5][3];
                break;
            case 9:
                minutemap[5][4] = this.sourcemap[5][4];
                break;
            default:
                break;
        }

        switch (minute / 10) {
            case 1:
                minutemap[3][5] = this.sourcemap[3][5];
            case 2:
                minutemap[3][1] = this.sourcemap[3][1];
                minutemap[3][5] = this.sourcemap[3][5];
                break;
            case 3:
                minutemap[3][2] = this.sourcemap[3][2];
                minutemap[3][5] = this.sourcemap[3][5];
                break;
            case 4:
                minutemap[3][3] = this.sourcemap[3][3];
                minutemap[3][5] = this.sourcemap[3][5];
                break;
            case 5:
                minutemap[3][4] = this.sourcemap[3][4];
                minutemap[3][5] = this.sourcemap[3][5];
                break;
            default:
                break;
        }
        this.map = minutemap;
    }

    private void setHourMap(int hour) {
        String[][] hourmap;
        hourmap = this.map;
        hourmap[2][5] = this.sourcemap[2][5];
        switch (hour % 12) {
            case 0:
                hourmap[2][2] = this.sourcemap[2][2];
                hourmap[2][4] = this.sourcemap[2][4];
                break;
            case 1:
                hourmap[0][0] = this.sourcemap[0][0];
                break;
            case 2:
                hourmap[0][1] = this.sourcemap[0][1];
                break;
            case 3:
                hourmap[0][2] = this.sourcemap[0][2];
                break;
            case 4:
                hourmap[0][3] = this.sourcemap[0][3];
                break;
            case 5:
                hourmap[0][4] = this.sourcemap[0][4];
                hourmap[0][5] = this.sourcemap[0][5];
                break;
            case 6:
                hourmap[1][0] = this.sourcemap[1][0];
                hourmap[1][1] = this.sourcemap[1][1];
                break;
            case 7:
                hourmap[1][2] = this.sourcemap[1][2];
                hourmap[1][3] = this.sourcemap[1][3];
                break;
            case 8:
                hourmap[1][4] = this.sourcemap[1][4];
                hourmap[1][5] = this.sourcemap[1][5];
                break;
            case 9:
                hourmap[2][0] = this.sourcemap[2][0];
                hourmap[2][1] = this.sourcemap[2][1];
                break;
            case 10:
                hourmap[2][2] = this.sourcemap[2][2];
                break;
            case 11:
                hourmap[2][2] = this.sourcemap[2][2];
                hourmap[2][3] = this.sourcemap[2][3];
                break;
            default:
                break;

        }


    }

}
