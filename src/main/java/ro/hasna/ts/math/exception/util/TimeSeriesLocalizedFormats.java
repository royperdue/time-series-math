package ro.hasna.ts.math.exception.util;

import org.apache.commons.math3.exception.util.Localizable;

import java.util.Locale;

/**
 * Enumeration for localized messages formats used in exceptions messages.
 *
 * @see org.apache.commons.math3.exception.util.LocalizedFormats
 * @since 1.0
 */
public enum TimeSeriesLocalizedFormats implements Localizable {
    NUMBER_NOT_DIVISIBLE_WITH("{0} is not divisible with {1}"),
    OUT_OF_RANGE_BOTH("{0} out of ({1}, {2}) range"),
    UNSUPPORTED_STRATEGY("the strategy {0} is not supported in {1}");

    /**
     * Source English format.
     */
    private final String sourceFormat;

    /**
     * Simple constructor.
     *
     * @param sourceFormat source English format to use when no localized version is available
     */
    TimeSeriesLocalizedFormats(final String sourceFormat) {
        this.sourceFormat = sourceFormat;
    }

    @Override
    public String getSourceString() {
        return sourceFormat;
    }

    @Override
    public String getLocalizedString(Locale locale) {
        return sourceFormat;
    }
}
