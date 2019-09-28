package com.huaa.chapter16.thread.safe;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/13 16:30
 */
class Tableware {

    private final String toolName;

    public Tableware(String toolName) {
        this.toolName = toolName;
    }

    @Override
    public String toString() {
        return "Tool: " + toolName;
    }
}
