package modulo;

import java.util.*;

/**
 * Nghịch đảo Modulo bằng phương pháp Euclid mở rộng
 * @author censodev
 */
public class EuclidReverseModulo {
    public static void main(String[] args) {
        calc(587, 4201, true);
    }

    public static int calc(int a, int n, boolean isPrint) {
        if (isPrint) {
            System.out.printf("x = %d^-1 mod %d\n", a, n);
            System.out.printf("<=> %d.x mod %d = 1\n", a, n);
            System.out.printf("<=> %d.x = %d.k + 1\n", a, n);
            System.out.printf("<=> %d.x + %d.y = 1 (with y = -k)\n", a, n);
        }

        Map<Integer, Integer> mapR = new HashMap<>();
        Map<Integer, Integer> mapQ = new HashMap<>();
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();

        mapR.put(-1, n);
        mapR.put(0, a);
        mapX.put(-1, 0);
        mapX.put(0, 1);
        mapY.put(-1, 1);
        mapY.put(0, 0);

        CmdTable st = new CmdTable();
        st.setShowVerticalLines(true);
        st.setHeaders("i", "ri", "qi", "xi", "yi");
        st.addRow("-1", mapR.get(-1).toString(), "", mapX.get(-1).toString(), mapY.get(-1).toString());
        st.addRow("0", mapR.get(0).toString(), "", mapX.get(0).toString(), mapY.get(0).toString());

        Integer k = 1;
        while (!mapR.containsValue(0)) {
            mapR.put(k, mapR.get(k - 2) % mapR.get(k - 1));
            mapQ.put(k, mapR.get(k - 2) / mapR.get(k - 1));
            mapX.put(k, mapX.get(k - 2) - mapQ.get(k) * mapX.get(k - 1));
            mapY.put(k, mapY.get(k - 2) - mapQ.get(k) * mapY.get(k - 1));
            st.addRow(k.toString(), mapR.get(k).toString(), mapQ.get(k).toString(), mapX.get(k).toString(), mapY.get(k).toString());
            k++;
        }

        if (isPrint) {
            st.print();
        }

        int rs = 0;
        for (Map.Entry<Integer, Integer> entry: mapR.entrySet()) {
            if (entry.getValue().equals(1)) {
                rs = mapX.get(entry.getKey());
                rs = rs > 0 ? rs : rs + n;
                if (isPrint) {
                    System.out.printf("=> x = %d%n", rs);
                }
                break;
            }
        }
        return rs;
    }

    private static class CmdTable {
        private static final String HORIZONTAL_SEP = "-";
        private String verticalSep;
        private String joinSep;
        private String[] headers;
        private List<String[]> rows = new ArrayList<>();
        private boolean rightAlign;

        public CmdTable() {
            setShowVerticalLines(false);
        }

        public void setRightAlign(boolean rightAlign) {
            this.rightAlign = rightAlign;
        }

        public void setShowVerticalLines(boolean showVerticalLines) {
            verticalSep = showVerticalLines ? "|" : "";
            joinSep = showVerticalLines ? "+" : " ";
        }

        public void setHeaders(String... headers) {
            this.headers = headers;
        }

        public void addRow(String... cells) {
            rows.add(cells);
        }

        public void print() {
            int[] maxWidths = headers != null ?
                    Arrays.stream(headers).mapToInt(String::length).toArray() : null;

            for (String[] cells : rows) {
                if (maxWidths == null) {
                    maxWidths = new int[cells.length];
                }
                if (cells.length != maxWidths.length) {
                    throw new IllegalArgumentException("Number of row-cells and headers should be consistent");
                }
                for (int i = 0; i < cells.length; i++) {
                    maxWidths[i] = Math.max(maxWidths[i], cells[i].length());
                }
            }

            if (headers != null) {
                printLine(maxWidths);
                printRow(headers, maxWidths);
                printLine(maxWidths);
            }
            for (String[] cells : rows) {
                printRow(cells, maxWidths);
            }
            if (headers != null) {
                printLine(maxWidths);
            }
        }

        private void printLine(int[] columnWidths) {
            for (int i = 0; i < columnWidths.length; i++) {
                String line = String.join("", Collections.nCopies(columnWidths[i] +
                        verticalSep.length() + 1, HORIZONTAL_SEP));
                System.out.print(joinSep + line + (i == columnWidths.length - 1 ? joinSep : ""));
            }
            System.out.println();
        }

        private void printRow(String[] cells, int[] maxWidths) {
            for (int i = 0; i < cells.length; i++) {
                String s = cells[i];
                String verStrTemp = i == cells.length - 1 ? verticalSep : "";
                if (rightAlign) {
                    System.out.printf("%s %" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
                } else {
                    System.out.printf("%s %-" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
                }
            }
            System.out.println();
        }
    }
}
