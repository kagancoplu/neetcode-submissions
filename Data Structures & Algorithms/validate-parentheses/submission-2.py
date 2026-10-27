class Solution:
    def isValid(self, s: str) -> bool:
        st = []
        pairs = {"]" : "[", "}" : "{", ")" : "("}
        for cur in s:
            if cur in pairs:
                if not st or st.pop() != pairs[cur]:
                    return False
            else:
                st.append(cur)
        return not st