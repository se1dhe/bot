package dev.se1dhe.bot.config;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

@Slf4j
public class PropertiesParser {

    private final File _file;
    private final Properties _properties = new Properties();

    public PropertiesParser(String name)
    {
        this(new File(name));
    }

    public PropertiesParser(File file)
    {
        _file = file;
        try (FileInputStream fileInputStream = new FileInputStream(file))
        {
            try (InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.defaultCharset()))
            {
                _properties.load(inputStreamReader);
            }
        }
        catch (Exception e)
        {
            log.warn("[" + _file.getName() + "] There was an error loading config reason: " + e.getMessage());
        }
    }



    public boolean containskey(String key)
    {
        return _properties.containsKey(key);
    }

    private String getValue(String key)
    {
        final String value = _properties.getProperty(key);
        return value != null ? value.trim() : null;
    }

    public boolean getBoolean(String key, boolean defaultValue)
    {
        final String value = getValue(key);
        if (value == null)
        {
            log.warn(("[" + _file.getName() + "] missing property for key: " + key + " using default value: " + defaultValue));
            return defaultValue;
        }

        if (value.equalsIgnoreCase("true"))
        {
            return true;
        }
        else if (value.equalsIgnoreCase("false"))
        {
            return false;
        }
        else
        {
            log.warn("[" + _file.getName() + "] Invalid value specified for key: " + key + " specified value: " + value + " should be \"boolean\" using default value: " + defaultValue);
            return defaultValue;
        }
    }

    public byte getByte(String key, byte defaultValue)
    {
        final String value = getValue(key);
        if (value == null)
        {
            log.warn("[" + _file.getName() + "] missing property for key: " + key + " using default value: " + defaultValue);
            return defaultValue;
        }

        try
        {
            return Byte.parseByte(value);
        }
        catch (NumberFormatException e)
        {
            log.warn("[" + _file.getName() + "] Invalid value specified for key: " + key + " specified value: " + value + " should be \"byte\" using default value: " + defaultValue);
            return defaultValue;
        }
    }

    public short getShort(String key, short defaultValue)
    {
        final String value = getValue(key);
        if (value == null)
        {
            log.warn("[" + _file.getName() + "] missing property for key: " + key + " using default value: " + defaultValue);
            return defaultValue;
        }

        try
        {
            return Short.parseShort(value);
        }
        catch (NumberFormatException e)
        {
            log.warn("[" + _file.getName() + "] Invalid value specified for key: " + key + " specified value: " + value + " should be \"short\" using default value: " + defaultValue);
            return defaultValue;
        }
    }

    public int getInt(String key, int defaultValue)
    {
        final String value = getValue(key);
        if (value == null)
        {
            log.warn("[" + _file.getName() + "] missing property for key: " + key + " using default value: " + defaultValue);
            return defaultValue;
        }

        try
        {
            return Integer.parseInt(value);
        }
        catch (NumberFormatException e)
        {
            log.warn("[" + _file.getName() + "] Invalid value specified for key: " + key + " specified value: " + value + " should be \"int\" using default value: " + defaultValue);
            return defaultValue;
        }
    }
    public double getDouble(String key, double defaultValue) {
        final String value = getValue(key);
        if (value == null) {
            log.warn("[" + _file.getName() + "] missing property for key: " + key + " using default value: " + defaultValue);
            return defaultValue;
        }

        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            log.warn("[" + _file.getName() + "] Invalid value specified for key: " + key + " specified value: " + value + " should be \"double\" using default value: " + defaultValue);
            return defaultValue;
        }
    }

    public long getLong(String key, long defaultValue)
    {
        final String value = getValue(key);
        if (value == null)
        {
            log.warn("[" + _file.getName() + "] missing property for key: " + key + " using default value: " + defaultValue);
            return defaultValue;
        }

        try
        {
            return Long.parseLong(value);
        }
        catch (NumberFormatException e)
        {
            log.warn("[" + _file.getName() + "] Invalid value specified for key: " + key + " specified value: " + value + " should be \"long\" using default value: " + defaultValue);
            return defaultValue;
        }
    }
    public String getString(String key, String defaultValue)
    {
        final String value = getValue(key);
        if (value == null)
        {
            log.warn("[" + _file.getName() + "] missing property for key: " + key + " using default value: " + defaultValue);
            return defaultValue;
        }
        return value;
    }
}