package com.test.model;

public enum JeanStyle {
        BOOTCUT, FLARE, RELAXED, SKINNY, STRAIGHT;

        /**
         * This method will return a string that represents the enum
         */
        @Override
        public String toString() {
            switch (this) {
                case BOOTCUT:
                    return "Bootcut";
                case FLARE:
                    return "Flare";
                case RELAXED:
                    return "Relaxed";
                case SKINNY:
                    return "Skinny";
                case STRAIGHT:
                    return "Straight";
                default:
                    return "";
            }
        }
    }

