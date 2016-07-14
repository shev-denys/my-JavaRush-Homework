package com.javalearn.test.myTests;


import java.io.*;

import java.util.*;

import org.dom4j.*;


/**
 * Created by Admin on 08.01.2015.
 */
public class SolutionFileParse
{
    public static void main(String[] args) throws IOException
    {
        //по условию не сказано как получать имена файлов, поэтому возьмем самый простой и расправстранненй
        //вариант - считаем с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Получим содержимое обоих файлов
        LinkedList<String> file1Content = readFile(reader.readLine());
        LinkedList<String> file2Content = readFile(reader.readLine());

        //Check if any file null or empty
        if (file1Content == null) return;
        else if (file1Content.size() == 0) return;

        if (file2Content == null) return;
        else if (file2Content.size() == 0) return;

        //lets parse file conteins
        LinkedList<TreeMap<String, Object>> file1AfterParsing = StringsParser(file1Content);
        LinkedList<TreeMap<String, Object>> file2AfterParsing = StringsParser(file2Content);

        //есть два распарсеных файла которые необходимо сравнить
        LinkedList<Boolean> results = new LinkedList<>();
        int maxcount = file1AfterParsing.size() < file2AfterParsing.size() ? file1AfterParsing.size() : file2AfterParsing.size();
        for (int i = 0; i < maxcount; i++)
        {
            results.add(equals(file1AfterParsing.get(i), file2AfterParsing.get(i)));
        }
        for (int i = 0; i < results.size(); i++)
        {
            System.out.println("In " + (i + 1) + " line: " + results.get(i));
        }
    }

    public static Boolean equals(TreeMap<String, Object> tree1, TreeMap<String, Object> tree2)
    {
        try
        {
            for (Map.Entry<String, Object> entry : tree1.entrySet())
            {
                Object val1 = entry.getValue();
                Object val2 = tree2.get(entry.getKey());

                if (val1.getClass().equals(val2.getClass()) || (val1 instanceof Number && val2 instanceof Number))
                {
                    if (val1 instanceof Integer || val1 instanceof Double || val1 instanceof String)
                    {
                        if (val1 instanceof Double || val1 instanceof Integer)
                            if (!equals(new Double(val1.toString()), new Double(val2.toString()))) return false;
                            else if (val1 instanceof String)
                                if (!equals((String) val1, (String) val2)) return false;
                    } else if (val1 instanceof TreeMap)
                    {
                        if (!equals((TreeMap) val1, (TreeMap) val2)) return false;
                    } else if (val1 instanceof LinkedList)
                    {
                        if (!equals((LinkedList) val1, (LinkedList) val2)) return false;
                        ;
                    }
                } else
                    return false;

            }
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public static Boolean equals(LinkedList<Object> tree1, LinkedList<Object> tree2)
    {
        if (tree1.size() != tree2.size())
            return false;
        int length = tree1.size();

        for (int i = 0; i < length; i++)
        {
            Object val1 = tree1.get(i);
            Object val2 = tree2.get(i);
            if (val1.getClass().equals(val2.getClass()) || (val1 instanceof Number && val2 instanceof Number))
            {
                if (val1 instanceof Integer || val1 instanceof Double || val1 instanceof String)
                {
                    if (val1 instanceof Double || val1 instanceof Integer)
                        if (!equals(new Double(val1.toString()), new Double(val2.toString()))) return false;
                        else if (val1 instanceof String)
                            if (!equals((String) val1, (String) val2)) return false;
                } else if (val1 instanceof TreeMap)
                {
                    if (!equals((TreeMap) val1, (TreeMap) val2)) return false;
                } else if (val1 instanceof LinkedList)
                {
                    if (!equals((LinkedList) val1, (LinkedList) val2)) return false;
                    ;
                }
            } else
                return false;


            //if(!equals(tree1.get(i),tree2.get(i))) return false;
        }

        return true;
    }

    public static Boolean equals(Integer tree1, Integer tree2)
    {
        return tree1.equals(tree2);
    }

    public static Boolean equals(Double tree1, Double tree2)
    {
        return tree1.equals(tree2);
    }

    public static Boolean equals(String tree1, String tree2)
    {
        return tree1.equals(tree2);
    }

    public static LinkedList<String> readFile(String filename)
    {
        Scanner reader = null;
        LinkedList<String> result = new LinkedList<>();
        try
        {
            reader = new Scanner(new FileInputStream(filename));

            while (reader.hasNext())
                result.add(reader.nextLine());
        }
        catch (IOException e)
        {

        }
        return result;
    }

    //Для получения результата использован связный сисок содержащий отсортированную по хеш-значению наименования значений карту
    //это позволяет не нарушать порядок следования строк, но при этому упорядочнивает для упрощенния дальнейшего сравнения
    //значения которые содержит строка
    public static LinkedList<TreeMap<String, Object>> StringsParser(LinkedList<String> fileContent)
    {

        LinkedList<TreeMap<String, Object>> result = new LinkedList<>();
        for (String sTemp : fileContent)
        {
            //Предположим что если это хмл- нод, то в его тексте должен содержаться текст "?xml version="
            if (sTemp.contains("?xml version="))
                result.add(GetXMLNodeValue(sTemp));
            else
                result.add(GetSimpleStringValue(sTemp));
        }
        return result;
    }

    public static TreeMap<String, Object> GetXMLNodeValue(String s)
    {

        TreeMap<String, Object> result = new TreeMap<>();
        try
        {
            Document document = DocumentHelper.parseText(s);
            Element root = document.getRootElement();

            if (root.nodeCount() > 1)
            {
                TreeMap<String, Object> curNode = new TreeMap<>();
                result.put(root.getName(), curNode);

                ReadTree(root, curNode);
            } else
            {
                result.put(root.getName(), ParseSimpleData(root.getStringValue()));
            }
        }

        catch (DocumentException e)
        {
            e.printStackTrace();
        }

        return result;

    }

    public static void ReadTree(Element element, TreeMap<String, Object> curNode)
    {
        for (int i = 0, size = element.nodeCount(); i < size; i++)
        {
            Node node = element.node(i);
            if (node instanceof Element)
            {
                TreeMap<String, Object> newNode = new TreeMap<>();
                curNode.put(node.getName(), ParseSimpleData(node.getStringValue()));
                ReadTree((Element) node, newNode);
            } else
            {
                curNode.put(element.getName(), ParseSimpleData(node.getStringValue()));
            }
        }
    }


    public static TreeMap<String, Object> GetSimpleStringValue(String s)
    {
        //если правильно понял, то из простейших типов данных может быть только
        //double, int, string

        TreeMap<String, Object> result = new TreeMap<>();
        for (String sTemp : s.split("&")) //Если правильно понял условие то все значения разделены знаком '&'
        {
            String valueName = sTemp.substring(0, sTemp.indexOf("="));
            String valueNotParsed = sTemp.substring(sTemp.indexOf("=") + 1);
            //Разберем строку которая следует после знака "="

            if (valueNotParsed.contains(":")) //если правильно понял из условия двумерный массив разделен двоеточием
            {
                LinkedList<LinkedList<Object>> valueT = new LinkedList<>();
                String[] strArr = valueNotParsed.split(":");
                //В данной точке непонятно какого типа данные в массиве,
                for (String sArrValue : strArr)
                {
                    //значения одномерного массива разделены запятыми
                    String[] strSimple = sArrValue.split(",");
                    LinkedList<Object> arr = new LinkedList<>();

                    for (String sFirstLevel : strSimple)
                    {
                        arr.add(ParseSimpleData(sFirstLevel));
                    }
                    valueT.add(getSortedLinkedList(arr));

                }
                result.put(valueName, getSortedLinkedList(valueT, true));
            } else if (valueNotParsed.contains(",")) //одномерный массив
            {
                LinkedList<Object> valueT = new LinkedList<>();
                //значения одномерного массива разделены запятыми
                String[] strSimple = valueNotParsed.split(",");
                for (String sFirstLevel : strSimple)
                    valueT.add(ParseSimpleData(sFirstLevel));
                //Упорядочним для того чтоб в дальнейшем было просто сравнивать

                result.put(valueName, getSortedLinkedList(valueT));
            } else //иначе простой тип данных - число с плавающей, целое число, строка
            {
                result.put(valueName, ParseSimpleData(valueNotParsed));
            }
        }
        return result;
    }

    //Сортировка списка
    //
    private static LinkedList getSortedLinkedList(LinkedList<Object> value)
    {
        //узнаем максимально широкий тип который содержится в списке, к нему и приведем всю структуру
        Object obj = value.get(0);
        for (Object t : value)
        {
            if (t instanceof String)
            {
                obj = t;
                break;
            }

            if (t instanceof Double)
            {
                obj = t;
            }
        }

        if (obj instanceof Double)
        {
            LinkedList<Double> list = new LinkedList<>();
            for (Object o : value)
                list.add(new Double(o.toString()));
            Collections.sort(list);
            //LinkedList<Object> a = (LinkedList<Object>)list;
            return list;//((LinkedList<Object>));
        } else if (obj instanceof Integer)

        {
            LinkedList<Integer> list = new LinkedList<>();
            for (Object o : value)
                list.add(new Integer(o.toString()));
            Collections.sort(list);
            return list;
        } else //if(value.get(0) instanceof String)
        {
            LinkedList<String> list = new LinkedList<>();
            for (Object o : value)
                list.add(o.toString());
            Collections.sort(list);
            return list;
        }
    }

    //Сортировка списка списков
    //сортировка происходим относительно суммы каждого внутреннего списка
    private static LinkedList getSortedLinkedList(LinkedList<LinkedList<Object>> value, boolean i)
    {
        //узнаем максимально широкий тип который содержится в списке, к нему и приведем всю структуру
        Object obj = value.get(0).get(0);
        for (LinkedList<Object> list : value)
        {
            for (Object t : list)
            {

                if (t instanceof String)
                {
                    obj = t;
                    break;
                }

                if (t instanceof Double)
                {
                    obj = t;
                }
            }
        }

        if (obj instanceof Double)
        {
            LinkedList<LinkedList<Double>> list = new LinkedList<>();
            /*for (int i =0;i<value.size();i++)
            {
                LinkedList<Double> temp= new LinkedList<>();
                for (int j=0;j<value.get(i).size();j++)
                    temp.add(new Double(value.get(i).get(j).toString()));
                list.add(temp);
            }*/

            for (Object o : value)
                list.add((LinkedList<Double>) o);

            Collections.sort(list, new Comparator<LinkedList<Double>>()
            {
                public int compare(LinkedList<Double> o1, LinkedList<Double> o2)
                {
                    Double sum1 = new Double(0);
                    Double sum2 = new Double(0);
                    for (int i = 0; i < o1.size(); i++)
                        sum1 += new Double(String.valueOf(o1.get(i))) * (i + 32);
                    for (int i = 0; i < o2.size(); i++)
                        sum2 += new Double(String.valueOf(o2.get(i))) * (i * 32);
                    return sum1.compareTo(sum2);
                }
            });
            return list;
        } else if (obj instanceof Integer)

        {
            LinkedList<LinkedList<Integer>> list = new LinkedList<>();
            for (Object o : value)
                list.add((LinkedList<Integer>) o);
            Collections.sort(list, new Comparator<LinkedList<Integer>>()
            {
                public int compare(LinkedList<Integer> o1, LinkedList<Integer> o2)
                {
                    Integer sum1 = new Integer(0);
                    Integer sum2 = new Integer(0);
                    for (int i = 0; i < o1.size(); i++)
                        sum1 += o1.get(i) * i;
                    for (int i = 0; i < o2.size(); i++)
                        sum2 += o2.get(i) * i;
                    return sum1.compareTo(sum2);
                }
            });
            return list;
        } else //if(value.get(0) instanceof String)
        {
            LinkedList<LinkedList<String>> list = new LinkedList<>();
            for (Object o : value)
                list.add((LinkedList<String>) o);
            Collections.sort(list, new Comparator<LinkedList<String>>()
            {
                public int compare(LinkedList<String> o1, LinkedList<String> o2)
                {
                    Integer sum1 = new Integer(0);
                    Integer sum2 = new Integer(0);
                    for (int i = 0; i < o1.size(); i++)
                    {
                        sum1 += String.valueOf(o1.get(i)).hashCode() * (i + 32);
                    }
                    for (int i = 0; i < o2.size(); i++)
                        sum2 += String.valueOf(o2.get(i)).hashCode() * (i + 32);
                    return sum1.compareTo(sum2);
                }
            });
            return list;
        }


    }

    //Функция которая возвращает преобразованное к наипростейшему типу значение
    private static Object ParseSimpleData(String string)
    {
        try
        {
            if (string.contains(".")) //для того чтоб Integer не распарсился как double
                return Double.parseDouble(string);
            else throw new NullPointerException();
        }
        catch (Exception e)
        {
        }
        try
        {
            return Integer.parseInt(string);
        }
        catch (Exception e)
        {
        }
        return string;
    }


}
