package com.example.ezbuyapplication


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class EspressoTesting {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun espressoTesting() {
        val appCompatEditText = onView(
            allOf(
                withId(R.id.editTextUsername),
                childAtPosition(
                    allOf(
                        withId(R.id.LinearLayoutLoginPage),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("tanzekai.zkt@gmail.com"))

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.editTextPassword),
                childAtPosition(
                    allOf(
                        withId(R.id.LinearLayoutLoginPage),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText("1234567"))

        val materialButton = onView(
            allOf(
                withId(R.id.buttonLogin), withText("Login"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val materialButton2 = onView(
            allOf(
                withId(R.id.buttonAdd), withText("Add"),
                childAtPosition(
                    allOf(
                        withId(R.id.ProductListLayout),
                        childAtPosition(
                            withId(R.id.rcyView_Home),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )


        val materialButton3 = onView(
            allOf(
                withId(R.id.buttonCheckOut), withText("Check Out"),
                childAtPosition(
                    allOf(
                        withId(R.id.csyLayout_ShoppingAll),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.editTextSearch),
                childAtPosition(
                    allOf(
                        withId(R.id.cstLayout_Home),
                        withParent(withId(R.id.viewPager))
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText("qipao"))

        val materialButton4 = onView(
            allOf(
                withId(R.id.buttonSearch), withText("Search"),
                childAtPosition(
                    allOf(
                        withId(R.id.cstLayout_Home),
                        withParent(withId(R.id.viewPager))
                    ),
                    1
                ),
                isDisplayed()
            )
        )

        val materialButton5 = onView(
            allOf(
                withId(R.id.buttonAdd), withText("Add"),
                childAtPosition(
                    allOf(
                        withId(R.id.ProductListLayout),
                        childAtPosition(
                            withId(R.id.rcyView_Home),
                            3
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )


        val tabView = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tabBarLayout),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )

        val tabView2 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tabBarLayout),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )


        val materialButton6 = onView(
            allOf(
                withId(R.id.btnActSetting), withText("Account Settings"),
                childAtPosition(
                    allOf(
                        withId(R.id.linearLayout_AboutUs),
                        childAtPosition(
                            withId(R.id.cstLayoutProfile),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )

        val materialButton7 = onView(
            allOf(
                withId(R.id.btnHelpCenter), withText("Help Center"),
                childAtPosition(
                    allOf(
                        withId(R.id.linearLayout_AboutUs),
                        childAtPosition(
                            withId(R.id.cstLayoutProfile),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )

        val materialButton8 = onView(
            allOf(
                withId(R.id.ChatWithEzBuy), withText("Chat with EzLearn"),
                childAtPosition(
                    allOf(
                        withId(R.id.linearLayout_AboutUs),
                        childAtPosition(
                            withId(R.id.cstLayoutProfile),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )

        val materialButton9 = onView(
            allOf(
                withId(R.id.buttonLogout), withText("Log Out"),
                childAtPosition(
                    allOf(
                        withId(R.id.fragmentProfile),
                        childAtPosition(
                            withId(R.id.fragmentContainerView),
                            0
                        )
                    ),
                    4
                ),
                isDisplayed()
            )
        )

        val materialButton10 = onView(
            allOf(
                withId(R.id.buttonRegister), withText("Register"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.editTextUsernameSU),
                childAtPosition(
                    allOf(
                        withId(R.id.LinearLayoutSignUp),
                        childAtPosition(
                            withId(R.id.cstLayout_SignUp),
                            2
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText4.perform(replaceText("testtest@gmail.com"))

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.editTextPasswordSU),
                childAtPosition(
                    allOf(
                        withId(R.id.LinearLayoutSignUp),
                        childAtPosition(
                            withId(R.id.cstLayout_SignUp),
                            2
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText5.perform(replaceText("1234567"))

        val materialButton11 = onView(
            allOf(
                withId(R.id.buttonSignUp), withText("Login"),
                childAtPosition(
                    allOf(
                        withId(R.id.cstLayout_SignUp),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )

        val tabView3 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tabBarLayout),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )

        val materialButton12 = onView(
            allOf(
                withId(R.id.buttonLogout), withText("Log Out"),
                childAtPosition(
                    allOf(
                        withId(R.id.fragmentProfile),
                        childAtPosition(
                            withId(R.id.fragmentContainerView),
                            0
                        )
                    ),
                    4
                ),
                isDisplayed()
            )
        )
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
