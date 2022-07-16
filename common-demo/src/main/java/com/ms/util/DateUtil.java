package com.ms.util;

import com.ms.exception.TestException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {

    public static final String COMMON_PATTEN = "yyyy-MM-dd HH:mm:ss";
    public static final String COMMON_SIMPLE_PATTEN = "yyyy-MM-dd";
    public static final String COMMON_MONTH_PATTEN = "yyyyMM";
    public static final String COMMON_SE_MONTH_PATTEN = "yyyy-MM";
    public static final String COMMON_DAY_PATTEN = "yyyyMMdd";
    public static final DateTimeFormatter MINUTE_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static final DateTimeFormatter SLASH_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    public static final DateTimeFormatter SINGLE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/M/d");
    public static final DateTimeFormatter HYPHEN_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter HYPHEN_SECOND_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter CHINESE_FORMATTER = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
    public static final DateTimeFormatter CHINESE_HOUR_FORMATTER = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时");
    public static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyyMM");
    public static final DateTimeFormatter SE_MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");
    public static final DateTimeFormatter DAY_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter SECOND_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static final DateTimeFormatter MINUTE_FORMATTER_CONTINUE = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
    public static final DateTimeFormatter FULL_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter MINUTE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    public static final DateTimeFormatter MINUTE_SECOND_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HHmmss");

    public static Date str2Date(String date, String patten) {
        if (StringUtils.isEmpty(date) || StringUtils.isEmpty(patten)) {
            return null;
        }
        try {
            SimpleDateFormat dft = new SimpleDateFormat(patten);
            return dft.parse(date);
        } catch (Exception e) {
            log.error("{}格式转换错误：{}", date, patten);
            return null;
        }
    }

    public static Date str2FullDate(String str, DateTimeFormatter formatter) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(str, formatter);
            ZoneId zoneId = ZoneId.systemDefault();
            Instant instant = localDateTime.atZone(zoneId).toInstant();
            return Date.from(instant);
        } catch (DateTimeParseException e) {
            log.error("date parse error {}", e.getMessage(), e);
            return null;
        }
    }

    public static Date str2Date(String str) {
        return str2Date(str, SLASH_FORMATTER);
    }

    public static Date str2DateNew(String str) {
        return str2Date(str, HYPHEN_FORMATTER);
    }

    /**
     * 默认字符串转化时分秒格式
     *
     * @param str
     * @return
     */
    public static Date str2DateTime(String str) {
        return str2DateTime(str, FULL_DATE_FORMATTER);
    }

    public static Date str2DateTime(String str, DateTimeFormatter dateTimeFormatter) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            LocalDateTime localDate = LocalDateTime.parse(str, dateTimeFormatter);
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zdt = localDate.atZone(zoneId);
            return Date.from(zdt.toInstant());
        } catch (DateTimeParseException e) {
            log.error("date parse error {}", e.getMessage(), e);
            return null;
        }
    }

    public static Date str2Date(String str, DateTimeFormatter formatter) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            LocalDate localDate = LocalDate.parse(str, formatter);
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
            return Date.from(zdt.toInstant());
        } catch (DateTimeParseException e) {
            log.error("date parse error {}", e.getMessage(), e);
            return null;
        }
    }

    public static LocalDate str2LocalDate(String str, DateTimeFormatter formatter) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        return LocalDate.parse(str, formatter);
    }

    /**
     * 计算月份差
     *
     * @param dateFirst
     * @param dateSecond
     * @return
     */
    public static Integer calMonthDiffer(Date dateFirst, Date dateSecond) {
        if (dateFirst == null || dateSecond == null) {
            return null;
        }
        LocalDate endDate = DateUtil.date2LocalDate(dateFirst.after(dateSecond) ? dateFirst : dateSecond);
        LocalDate beginDate = DateUtil.date2LocalDate(dateFirst.after(dateSecond) ? dateSecond : dateFirst);
        return calMonthDiffer(beginDate, endDate);
    }

    /**
     * 计算月份差
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static Integer calMonthDiffer(LocalDate beginDate, LocalDate endDate) {
        if (beginDate == null || endDate == null) {
            return null;
        }
        return endDate.getYear() * 12 + endDate.getMonthValue()
                - (beginDate.getYear() * 12 + beginDate.getMonthValue());
    }

    public static int differentDaysByMillisecond(Date date1, Date date2) {
        return (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
    }

    public static String date2Str(Date date) {
        return date2Str(date, SLASH_FORMATTER);
    }

    public static String date2Str(Date date, DateTimeFormatter formatter) {
        if (date == null) {
            return null;
        }

        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime dt = LocalDateTime.ofInstant(date.toInstant(), zoneId);
        return dt.format(formatter);
    }

    public static String localDate2Str(LocalDate localDate) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(COMMON_SIMPLE_PATTEN);
        return localDate.format(fmt);
    }

    /**
     * LocalDate转Date
     *
     * @param localDate
     * @return
     */
    public static Date local2Date(LocalDate localDate) {
        if (localDate == null) {
            localDate = LocalDate.parse("1970-01-01", HYPHEN_FORMATTER);
        }
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * LocalDateTime转Date
     *
     * @param localTime
     * @return
     */
    public static Date localTime2Date(LocalDateTime localTime) {
        if (localTime == null) {
            localTime = LocalDateTime.parse("1970-01-01 00:00:00", DateTimeFormatter.ofPattern(COMMON_PATTEN));
        }
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * localDate转date
     *
     * @param localDate
     * @return
     */
    public static Date localEnd2Date(LocalDate localDate) {
        if (Objects.isNull(localDate)) {
            localDate = LocalDate.now();
        }
        return localTime2Date(localDate.atTime(23, 59, 59));
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getCurrentDateTime() {
        LocalDateTime localDate = LocalDateTime.now();
        return localTime2Date(localDate);
    }

    /**
     * Date转LocalDate
     *
     * @param date
     * @return
     */
    public static LocalDate date2LocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    /**
     * Date转LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * 格式化Date
     */
    public static String formatDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.format(MINUTE_FORMATTER);
    }

    /**
     * 格式化日期 年月日格式
     *
     * @param localDate
     * @return
     */
    public static String formatLocalDateChinese(LocalDate localDate) {
        if (localDate == null) {
            return "1970年01月01日";
        } else {
            return CHINESE_FORMATTER.format(localDate);
        }
    }

    /**
     * 格式化时间为年月日时
     *
     * @param date
     * @return
     */
    public static String formatDateChineseHour(Date date) {
        if (date == null) {
            return "1970年01月01日0时";
        } else {
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDateTime dt = LocalDateTime.ofInstant(date.toInstant(), zoneId);
            return dt.format(CHINESE_HOUR_FORMATTER);
        }
    }

    /**
     * 移除日期时分秒
     *
     * @param date
     * @return
     */
    public static Date removeHms(Date date) {
        return local2Date(date2LocalDate(date));
    }

    /**
     * 返回当天到日
     *
     * @return
     */
    public static Date getNowDateDay() {
        return removeHms(new Date());
    }


    /**
     * 计算两个日期天数差
     *
     * @param start
     * @param end
     * @return
     */
    public static final int calcDayOffset(LocalDate start, LocalDate end) {
        return calcDayOffset(local2Date(start), local2Date(end));
    }

    /**
     * 计算时间戳之差
     *
     * @param start
     * @param end
     * @return
     */
    public static int calcDayOffset(long start, long end) {
        return calcDayOffset(new Date(start), new Date(end));
    }

    /**
     * 计算两个日期之间的天数差
     *
     * @param start
     * @param end
     * @return
     */
    public static int calcDayOffset(Date start, Date end) {
        //先转localDate是为了去除date中时分秒的部分，防止计算天数产生误差
        return (int) Duration.between(localDate2Time(date2LocalDate(start)), localDate2Time(date2LocalDate(end))).toDays();
    }

    public static Integer calcDayOffsetAbs(Date start, Date end) {
        if (start == null || end == null) {
            return null;
        }
        return Math.abs(calcDayOffset(start, end));
    }

    /**
     * 计算两个日期之间的时数差
     *
     * @param start
     * @param end
     * @return
     */
    public static int calcHourOffSet(Date start, Date end) {
        return (int) Duration.between(date2LocalDateTime(start), date2LocalDateTime(end)).toHours();
    }

    /**
     * 计算两个日期之间的分钟数差
     *
     * @param start
     * @param end
     * @return
     */
    public static int calcMinuteOffSet(Date start, Date end) {
        return (int) Duration.between(date2LocalDateTime(start), date2LocalDateTime(end)).toMinutes();
    }





    /**
     * 获取距离指定时间距离指定天数后的时间
     *
     * @param date 指定待计算的时间
     * @param days 指定天数（正数为增加，负数为减少）
     * @return 若上述任意参数未传，返回当前时间；否则返回计算结果
     */
    public static Date getDateAddDays(Date date, Integer days) {
        if (days == null || date == null) {
            return new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, days);
        return cal.getTime();
    }

    /**
     * 获取距离指定时间距离指定天数后的时间
     *
     * @param date  指定待计算的时间
     * @param hours 指定小时数（正数为增加，负数为减少，默认使用24小时制）
     * @return 若上述任意参数未传，返回当前时间；否则返回计算结果
     */
    public static Date getDateAddHours(Date date, Integer hours) {
        if (hours == null || date == null) {
            return new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, hours);
        return cal.getTime();
    }


    /**
     * 判断传入时间是否是当天
     *
     * @param localDate
     * @return
     */
    public static final boolean isToday(LocalDate localDate) {
        return LocalDate.now().isEqual(localDate);
    }

    /**
     * 判断传入时间是否是当天
     *
     * @param date
     * @return
     */
    public static final boolean isToday(Date date) {
        return isToday(date2LocalDate(date));
    }


    /**
     * 日期增加天数
     *
     * @param date
     * @param day
     * @return
     */
    public static Date datePlusDay(Date date, Integer day) {
        date = Optional.ofNullable(date).orElse(new Date());
        day = Optional.ofNullable(day).orElse(0);
        return local2Date(date2LocalDate(date).plus(day, ChronoUnit.DAYS));
    }

    /**
     * 增加月份
     *
     * @param date
     * @param month
     * @return
     */
    public static Date datePlusMonth(Date date, Integer month) {
        date = Optional.ofNullable(date).orElse(new Date());
        month = Optional.ofNullable(month).orElse(0);
        return local2Date(date2LocalDate(date).plus(month, ChronoUnit.MONTHS));
    }


    /**
     * 获得当前日期是一个星期的第几天（若传入空值，返回0）
     *
     * @param currentDate
     * @return
     */
    public static Integer getCurrentWeekDay(Date currentDate) {
        if (currentDate == null) {
            return 0;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        int result = cal.get(Calendar.DAY_OF_WEEK);
        // 需减去1天，因calender中，默认周日为一周的开始，周六为一周的结束
        if (result - 1 > 0) {
            return result - 1;
        } else {
            // 为0时返回7，说明是周日
            return 7;
        }
    }



    /**
     * localDate转localDateTime
     *
     * @param date
     * @return
     */
    private static LocalDateTime localDate2Time(LocalDate date) {
        return date2LocalDateTime(local2Date(date));
    }

    /**
     * 时间转换 dateTime 2 time
     *
     * @param localDateTime
     * @return
     */
    public static LocalTime localDateTime2LocalTime(LocalDateTime localDateTime) {
        return LocalTime.of(localDateTime.getHour(),
                localDateTime.getMinute(),
                localDateTime.getSecond());
    }

    /**
     * 获取当前时间戳后x位数字
     *
     * @param size 长度
     * @return
     */
    public static String getTimeRandomValue(Integer size) {
        String value = String.valueOf(System.currentTimeMillis());
        if (value.length() <= size) {
            return value;
        }
        return value.substring(value.length() - size);
    }


    /**
     * 获取日期当月的最后日期
     *
     * @param start
     * @return
     */
    public static LocalDate getLastDayOfMonth(LocalDate start) {
        if (Objects.isNull(start)) {
            throw new TestException("获取当月最后日期参数不能为空");
        }
        return Month.DECEMBER == start.getMonth()
                ? LocalDate.of(start.getYear(), start.getMonth(), 31)
                : LocalDate.of(start.getYear(), start.plusMonths(1).getMonth(), 1).minusDays(1);
    }

    public static LocalDate getLastDayOfMonth(Date start) {
        return getLastDayOfMonth(DateUtil.date2LocalDate(start));
    }

    public static LocalDate getFirstDayOfMonth(LocalDate date) {
        return getFirstDayOfMonth(DateUtil.local2Date(date));
    }

    /**
     * 获取日期当月第一天
     *
     * @param date
     * @return
     */
    public static LocalDate getFirstDayOfMonth(Date date) {
        if (Objects.isNull(date)) {
            throw new TestException("获取当月首日参数不能为空");
        }
        LocalDate localDate = date2LocalDate(date);
        return LocalDate.of(localDate.getYear(), localDate.getMonth(), 1);
    }

    /**
     * 获取当月最后一天日期
     *
     * @param month yyyyMM
     * @return yyyyMMdd
     */
    public static String getLastDay(String month) {
        if (StringUtils.isEmpty(month)) {
            return null;
        }
        LocalDate date = LocalDate.parse(month + "01", DAY_FORMATTER);
        LocalDate last = date.with(TemporalAdjusters.lastDayOfMonth());
        return last.format(DAY_FORMATTER);
    }



    /**
     * 获取当前月的第一天
     *
     * @return
     */
    public static LocalDate getFirstDay() {
        return LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获取当年的第一天
     *
     * @return
     */
    public static LocalDate getYearFirstDay() {
        return LocalDate.now().with(TemporalAdjusters.firstDayOfYear());
    }

    /**
     * 至今天数
     *
     * @param date
     * @param formatter
     * @return
     */
    public static Integer calcDateToNow(String date, DateTimeFormatter formatter) {
        return Optional.ofNullable(str2Date(date, formatter))
                .map(p -> calcDayOffset(p, getCurrentDateTime()))
                .orElse(null);
    }

    /**
     * 至今天数
     *
     * @param date
     * @param formatter
     * @return
     */
    public static Integer calcNow2Date(String date, DateTimeFormatter formatter) {
        Integer data2Now = calcDateToNow(date, formatter);
        return null == data2Now ? null : data2Now * -1;
    }

    /**
     * 获取当前年份
     *
     * @return
     */
    public static Integer getYearNow() {
        Calendar date = Calendar.getInstance();
        return date.get(Calendar.YEAR);
    }

    /**
     * 获取当前月份
     *
     * @return
     */
    public static Integer getMonthNow() {
        Calendar date = Calendar.getInstance();
        return date.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取月数差
     * 1月31号和2月1号计算结果为1
     *
     * @param start
     * @param end
     * @return
     */
    public static int getMonthDiff(LocalDate start, LocalDate end) {
        int startYear = start.getYear();
        int startMonth = start.getMonthValue();
        int endYear = end.getYear();
        int endMonth = end.getMonthValue();
        return endYear * 12 + endMonth - startYear * 12 - startMonth;
    }

    /**
     * 获取月数差
     * 按对日算：
     * 1月31号和2月1号计算结果为0
     * 1月1号到2月1号为1
     *
     * @param start
     * @param end
     * @return
     */
    public static int getMonthDiffDayByDay(LocalDate start, LocalDate end) {
        int startDay = start.getDayOfMonth();
        int endDay = end.getDayOfMonth();
        int offset = endDay >= startDay ? 0 : -1;
        return getMonthDiff(start, end) + offset;
    }

    /**
     * 获取中间全部日期(包含起止)
     */
    public static List<String> getBetweenDays(Date start, Date end) {
        if (start == null || end == null) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);
        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        while(tempStart.before(tempEnd)){
            result.add(date2Str(tempStart.getTime(), DateUtil.DAY_FORMATTER));
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        result.add(date2Str(tempEnd.getTime(), DateUtil.DAY_FORMATTER));
        return result;
    }

    /**
     * 获取某个时间固定数量之前或之后的某个年月
     * @return
     */
    public static String getYearMonth(Date date,Integer month){
        Date date1  = datePlusMonth(date,month);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String format = sdf.format(date1);
        return format;
    }

    /**
     * 获取当月天数
     */
    public static Integer getDaysOfMonth(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取某年某月的第一天
     * @param timeStr
     * @return
     */
    public static String getYearMonthFirstDay(String timeStr){
        LocalDate parse = LocalDate.parse(timeStr, HYPHEN_FORMATTER);
        LocalDate with = parse.with(TemporalAdjusters.firstDayOfMonth());
        return with.toString();
    }

    /**
     * 获取某年某月的最后一天
     * @return
     */
    public static String getYearMonthEndDay(String timeStr){
        LocalDate parse = LocalDate.parse(timeStr, HYPHEN_FORMATTER);
        LocalDate with = parse.with(TemporalAdjusters.lastDayOfMonth());
        return with.toString();
    }

    public static String commonDayFormat(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(COMMON_DAY_PATTEN);
        return sdf.format(date);
    }

}
