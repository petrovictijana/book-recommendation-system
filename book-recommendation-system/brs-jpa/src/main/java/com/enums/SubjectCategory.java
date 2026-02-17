package com.enums;

/**
 * Represents the category of a subject associated with the Work.
 * <p>
 *     Each subject can belong to one of the following categories:
 *     <ul>
 *         <li>{@link #TOPIC} - general topics or themes</li>
 *         <li>{@link #PEOPLE} - characters in the Work</li>
 *         <li>{@link #TIME} - temporal references, periods or eras</li>
 *         <li>{@link #PLACE} - geographic locations related to the Work</li>
 *     </ul>
 * </p>
 */
public enum SubjectCategory {
    /**
     * General topic or theme.
     */
    TOPIC,
    /**
     * People associated with the Work.
     */
    PEOPLE,
    /**
     * Time period related to the work.
     */
    TIME,
    /**
     * Geographic place related to the work.
     */
    PLACE
}
